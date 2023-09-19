public class Main {
public static void main(String[] args) 
{
 BoundedBuffer log = BoundedBuffer.getInstance();
 log.insert("Teste0");
 log.insert("Teste1");
 log.insert("Teste2");
 log.insert("Teste3");
 log.insert("Teste4");
 String t = log.remove();
 String t1 = log.remove();
 String t2 = log.remove();
 String t3 = log.remove();
 String t4 = log.remove();
 System.exit(0);
}}