
public class BoundedBuffer implements Buffer
{  private static BoundedBuffer instance;
   private String[ ] buffer = new String[BUFFER_SIZE];
   private static final int BUFFER_SIZE = 5;
   private int count=0;	// numero de itens no buffer
   private int in=0;   	// aponta para proxima posicao livre
   private int out=0; 	// aponta proxima posicao cheia
   private BoundedBuffer(){}
   public static BoundedBuffer getInstance()
   { // buffer inicialmente esta vazio
    if (instance == null)
        instance = new BoundedBuffer();
    return instance;
   } 
// produtores chamam esse metodo
   public void insert(String item) { 
   while (this.count == BUFFER_SIZE); // nao faz nada, pois nao ha nenhum buffer livre 
   buffer[this.in] = item;  
   System.out.println("Inseriu o objeto " + buffer[this.in] + " na posicao " + this.in + " do buffer");
   ++this.count; // acrescenta um item ao buffer                  
   this.in = (this.in+1)%BUFFER_SIZE;              
} 
// consumidores chamam esse metodo
   public String remove() { 
   String item;
   while (this.count == 0); // nao faz nada, pois nao ha nada para consumir 
   item = this.buffer[this.out];
   System.out.println("Removeu o objeto " + this.buffer[this.out] + " na posicao " + this.out + " do buffer");
   --this.count; // remove um item do buffer 
   this.out = (this.out+1)%BUFFER_SIZE;
   return item;      
   }
}


