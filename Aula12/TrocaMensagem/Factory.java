import java.util.Vector;
import java.util.*;
public class Factory {  
       public Factory()
      {  // first create the message buffer     
         Channel mailBox = new MessageQueue();
         // now create the producer and consumer threads
         Thread producerThread = new Thread(new Producer(mailBox));
         Thread consumerThread = new Thread(new Consumer(mailBox));
          //start() method allocates memory for a new thread in the JVM, 
         //and calls the run() method      
         producerThread.start();
         consumerThread.start();               
      }
     
       public static void main(String args[]) { 
       //main() is used to call the Factory() constructor
       Factory server = new Factory();
      }
   }

