public interface Buffer
{
   // produtores chamam este metodo
   public abstract void insert(String item);

   // consumidores chamam este metodo
   public abstract String remove();
}
