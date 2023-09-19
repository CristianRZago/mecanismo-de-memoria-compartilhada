public interface Channel
{ 
     // Envia uma mensagem ao canal
	public  abstract void send(Object message);
        
    // Recebe uma mensagem ao canal
	public  abstract Object receive();
}
