import BuffersCorba.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
public class EstruturasCliente
{
   final static int PENSANDO = 1;
   final static int COMENDO = 2;
   final static int FOME = 3;
   final static int NR_FILOSOFOS = 5;
   final static int PRIMEIRO_FILOSOFO = 0;
   final static int ULTIMO_FILOSOFO = NR_FILOSOFOS - 1;
   
   Buffers buffersImpl;

   public EstruturasCliente(Buffers buffers)
   {
      this.buffersImpl = buffers;
      
   }

   public synchronized void pegarGarfos (int filosofo)
   {
      buffersImpl.setSituacao(filosofo, FOME);
      System.out.println("Filosofo " + filosofo + " está com fome ...");
      int aEsquerda = buffersImpl.getSituacao(aEsquerda(filosofo));
      int aDireita = buffersImpl.getSituacao(aDireita(filosofo));
      while ( aEsquerda == COMENDO ||  aDireita == COMENDO)
      {
         try
         {
            buffersImpl.addTentativa(filosofo);
            System.out.println("Filosofo " + filosofo + " tentou pegar os garfos e não conseguiu. ");
            if (aEsquerda == COMENDO) {
               System.out.println("Motivo: Filosofo " + aEsquerda(filosofo) + " está comendo...");
            }
            if (aDireita == COMENDO) {
               System.out.println("Motivo: Filosofo " + aDireita(filosofo) + " está comendo...");
            }
            System.out.println("Filosofo " + filosofo + " vai entrar em wait...");
            buffersImpl.addTentativa(filosofo);
            wait();
            System.out.println("Filosofo " + filosofo + " saiu do wait ...  ");
            aEsquerda = buffersImpl.getSituacao(aEsquerda(filosofo));
            aDireita = buffersImpl.getSituacao(aDireita(filosofo));
         }
         catch (InterruptedException e)
         {
            System.out.println("O Filósofo " + filosofo + " morreu devido a starvation");
         }
      }
      
      buffersImpl.setTentativa(filosofo,0);
      buffersImpl.setGarfo(garfoEsquerdo(filosofo), false);
      buffersImpl.setGarfo(garfoDireito(filosofo), false);
      buffersImpl.setSituacao(filosofo, COMENDO);
      System.out.println("Filosofo " + filosofo + " começou a comer...  ");
      imprimeEstadosFilosofos();
      imprimeGarfos();
      imprimeTentativas();
   }

   public synchronized void returningGarfos (int filosofo)
   {
      buffersImpl.setGarfo(garfoEsquerdo(filosofo), true);
      buffersImpl.setGarfo(garfoDireito(filosofo), true);
      int aEsquerda = buffersImpl.getSituacao(aEsquerda(filosofo));
      int aDireita = buffersImpl.getSituacao(aDireita(filosofo));

      if ( aEsquerda == FOME || aDireita == FOME)
      {
         notifyAll();
      }
      System.out.println("Filosofo " + filosofo + " comeu, devolveu os garfos e começou a pensar.");
      System.out.println("***********************************************************************");
      buffersImpl.setSituacao(filosofo, PENSANDO);
      
      imprimeEstadosFilosofos();
      imprimeGarfos();
      imprimeTentativas();
   }

   public int aDireita (int filosofo)
   {
      int direito;
      if (filosofo == ULTIMO_FILOSOFO)
      {
         direito = PRIMEIRO_FILOSOFO;
      }
      else
      {
         direito = filosofo + 1;
      }
      return direito;
   }

   public int aEsquerda (int filosofo)
   {
      int esquerdo;
      if (filosofo == PRIMEIRO_FILOSOFO)
      {
         esquerdo = ULTIMO_FILOSOFO;
      }
      else
      {
         esquerdo = filosofo - 1;
      }
      return esquerdo;
   }

   public int garfoEsquerdo (int filosofo)
   {
      int garfoEsquerdo = filosofo;
      return garfoEsquerdo;
   }

   public int garfoDireito (int filosofo)
   {
      int garfoDireito;
      if (filosofo == PRIMEIRO_FILOSOFO)
      {
         garfoDireito = ULTIMO_FILOSOFO;
      }
      else
      {
         garfoDireito = filosofo - 1;
      }
      return garfoDireito;
   }

   public void imprimeEstadosFilosofos ()
   {
      int [] filosofos = buffersImpl.getFilosofos();
      
      
   }

   public void imprimeGarfos ()
   {
      boolean [] garfos = buffersImpl.getGarfos();
      
   }

   public void imprimeTentativas ()
   {
      int [] filosofos = buffersImpl.getFilosofos();
      
   }
}