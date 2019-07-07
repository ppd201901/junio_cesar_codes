import BuffersCorba.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
import org.omg.PortableServer.POA;

import java.security.PublicKey;
import java.util.Properties;

class BuffersImpl extends BuffersPOA {
    final static int PENSANDO = 1;
    final static int COMENDO = 2;
    final static int FOME = 3;
    final static int NR_FILOSOFOS = 5;
    final static int PRIMEIRO_FILOSOFO = 0;
    final static int ULTIMO_FILOSOFO = NR_FILOSOFOS - 1;
    boolean[] garfos = new boolean[NR_FILOSOFOS];
    int[] filosofos = new int[NR_FILOSOFOS];
    int[] tentativas = new int[NR_FILOSOFOS];
    private ORB orb;

    public void setORB(ORB orb_val) {
        orb = orb_val; 
    }
    
    public BuffersImpl()
    {
       for (int i = 0; i < 5; i++)
       {
          garfos[i] = true;
          filosofos[i] = PENSANDO;
          tentativas[i] = 0;
       }
    }
    public synchronized boolean getGarfo(int garfo) {    
      return garfos[garfo];
    }  

    public synchronized void setGarfo(int garfo, boolean valor) {
      garfos[garfo] = valor;
    }

    public int getTentativa(int filosofo) {
      //System.out.println("getTentativa("+filosofo+")="+tentativas[filosofo]);
      return tentativas[filosofo];
    }

    public void addTentativa(int filosofo) {
       tentativas[filosofo] = tentativas[filosofo]++;
    }

    public void setTentativa(int filosofo, int valor) {
      
      tentativas[filosofo] = valor;
    }

    public int getSituacao(int filosofo) {
      
      return filosofos[filosofo];
    }

    public void setSituacao(int filosofo, int valor) {
      
      filosofos[filosofo] = valor;
    }

    public int [] getTentativas() {
      imprimeTentativas();
       return tentativas;
    }

    public  boolean [] getGarfos() {
       imprimeGarfos();
       return garfos;
    }

    public int [] getFilosofos() {
       imprimeEstadosFilosofos();
       return filosofos;
    }

    public void imprimeEstadosFilosofos ()
   {
      
      String texto = "*";
      System.out.println("*************************");
      for (int i = 0; i < NR_FILOSOFOS; i++)
      {
         switch (filosofos[i])
         {
            case PENSANDO :
               texto = "Filosofo " + i + ": PENSANDO";
               break;
            case FOME :
               texto = "Filosofo " + i + ": FOME";
               break;
            case COMENDO :
               texto = "Filosofo " + i + ": COMENDO";
               break;
         }
         System.out.println(texto + " ");
      }
      System.out.println("*************************");
   }

   public void imprimeGarfos ()
   {
     
      String garfo = "*";
      System.out.println("*************************");
      for (int i = 0; i < NR_FILOSOFOS; i++)
      {
         if (garfos[i])
         {
            garfo = "Garfo " + i + ": LIVRE";
         }
         else
         {
            garfo = "Garfo " + i + ": OCUPADO";
         }
         System.out.println(garfo + " ");
      }
      System.out.println("*************************");
   }

   public void imprimeTentativas ()
   {
      
      System.out.print("Tentou comer = [ ");
      for (int i = 0; i < NR_FILOSOFOS; i++)
      {
         System.out.print(filosofos[i] + " ");
      }
      System.out.println("]");
   }
}


public class EstruturasServer {

  public static void main(String args[]) {
    try{
      // cria e inicializa o ORB
      ORB orb = ORB.init(args, null);

      // obtem uma referência ao skeleton raiz (rootpoa) e ativa o gerente de skeletons (POAManager)
      POA rootpoa = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
      rootpoa.the_POAManager().activate();

      // cria um servidor e o registra no ORB
      BuffersImpl mesaImpl = new BuffersImpl();
      mesaImpl.setORB(orb); 

      // obtem um referencia do objeto no servidor
      org.omg.CORBA.Object ref = rootpoa.servant_to_reference(mesaImpl);
      Buffers href = (Buffers) BuffersHelper.narrow(ref);
          
      // obtém o contexto de nomes raiz
      
      org.omg.CORBA.Object objRef =
          orb.resolve_initial_references("NameService");
      // Usa NamingContextExt que é parte da especificação Interoperable
      // Naming Service (INS).
      NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);

      // faz o bind da referência ao Objeto no serviço de nome
      String name = "Buffers";
      NameComponent path[] = ncRef.to_name( name );
      ncRef.rebind(path, href);
      System.out.println("*****************************************");
      System.out.println("Estruturas Server pronto e aguardando ...");
      System.out.println("*****************************************");
      // aguarda pelas requisições dos clientes
      orb.run();
    } 
        
      catch (Exception e) {
        System.err.println("ERROR: " + e);
        e.printStackTrace(System.out);
      }
          
      System.out.println("Terminando Estruturas Server ...");
        
  }
}