import BuffersCorba.*;
public class Filosofo extends Thread
{
   final static int TEMPO_MAXIMO = 100;
   EstruturasCliente estruturasCliente;
   int filosofo;

   public Filosofo (String nome, EstruturasCliente estruturas, int fil)
   {
      super(nome);
      this.estruturasCliente = estruturas;
      filosofo = fil;
   }

   public void run ()
   {
      int tempo = 0;
      while (true)
      {
         tempo = (int) (Math.random() * TEMPO_MAXIMO);
         pensar(tempo);
         getGarfos();
         tempo = (int) (Math.random() * TEMPO_MAXIMO);
         comer(tempo);
         returnGarfos();
      }
   }

   public void pensar (int tempo)
   {
      try
      {
         
         sleep(tempo);
         
      }
      catch (InterruptedException e)
      {
         System.out.println("O Filófoso pensou em demasia");
      }
   }

   public void comer (int tempo)
   {
      try
      {
         
         sleep(tempo);
         
      }
      catch (InterruptedException e)
      {
         System.out.println("O Filósofo comeu em demasia");
      }
   }

   public void getGarfos()
   {
      estruturasCliente.pegarGarfos(filosofo);
   }

   public void returnGarfos()
   {
      estruturasCliente.returningGarfos(filosofo);
   }
}