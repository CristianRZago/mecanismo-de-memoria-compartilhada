import java.util.*;
class Producer implements Runnable
{  public Producer(Channel m) 
  { mbox = m;}              
   public void run()
   { Date message;
      while (true) { 
	   SleepUtilities.nap();   
        message = new Date();      
	   System.out.println("Producer produced " + message);
         // produz um item e o armazena no buffer
        mbox.send(message);}   
   }
   private  Channel mbox; }

