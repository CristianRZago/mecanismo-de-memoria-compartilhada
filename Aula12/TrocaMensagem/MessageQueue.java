import java.util.Vector;
public class MessageQueue implements Channel
{ private Vector queue;
  public MessageQueue()
  { queue = new Vector(); }
  // isso implementa um send sem bloqueio 
  public void send(Object item) { queue.addElement(item);  }
  // isso implementa um receive sem bloqueio    
   public Object receive() {
      if (queue.size() == 0)
	    return null;
      else 
         return queue.remove(0); }
}

