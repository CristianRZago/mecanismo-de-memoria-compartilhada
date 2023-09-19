#include <iostream>
#include <string>
#include <vector>
#include <thread>
#include <mutex>
#include <condition_variable>

const int BUFFER_SIZE = 5;

class BoundedBuffer {
private:
    std::vector<std::string> buffer;
    int count = 0;
    int in = 0;
    int out = 0;
    std::mutex mtx;
    std::condition_variable not_full;
    std::condition_variable not_empty;

public:
    BoundedBuffer() {
        buffer.resize(BUFFER_SIZE);
    }

    void insert(const std::string& item) {
        std::unique_lock<std::mutex> lock(mtx);
        not_full.wait(lock, [this] { return count < BUFFER_SIZE; });

        buffer[in] = item;
        std::cout << "Inseriu o objeto " << buffer[in] << " na posição " << in << " do buffer" << std::endl;
        ++count;
        in = (in + 1) % BUFFER_SIZE;
        not_empty.notify_all();
    }

    std::string remove() {
        std::unique_lock<std::mutex> lock(mtx);
        not_empty.wait(lock, [this] { return count > 0; });

        std::string item = buffer[out];
        std::cout << "Removeu o objeto " << buffer[out] << " na posição " << out << " do buffer" << std::endl;
        --count;
        out = (out + 1) % BUFFER_SIZE;
        not_full.notify_all();

        return item;
    }
};

int main() {
    BoundedBuffer buffer;
    std::thread producers[1];
    std::thread consumers[1];

    producers[0] = std::thread([&buffer]() {
        for (int i = 0; i < 5; ++i) {
            std::string item = "Teste" + std::to_string(i);
            buffer.insert(item);
        }
    });

    consumers[0] = std::thread([&buffer]() {
        for (int i = 0; i < 5; ++i) {
            std::string item = buffer.remove();
        }
    });

    producers[0].join();
    consumers[0].join();

    return 0;
}
