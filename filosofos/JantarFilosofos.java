import BuffersCorba.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;

public class JantarFilosofos
{
   static Buffers buffersImpl;

   public static void main (String[] args)
   {
      
         try{
           // Cria e inicializa o ORB
           ORB orb = ORB.init(args, null);
   
           // obtem o contexto de nomes raiz
           org.omg.CORBA.Object objRef = 
               orb.resolve_initial_references("NameService");
           // Usa NamingContextExt ao invés de NamingContext. Isto é
           // parte do INS (Interoperable naming Service).  
           NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
    
           // resolve a referência ao objeto no serviço de nomes.
           String name = "Buffers";
           buffersImpl = (Buffers) BuffersHelper.narrow(ncRef.resolve_str(name));
   
           System.out.println("Obtendo a handle para o Servidor de Objetos: " + buffersImpl);
           EstruturasCliente estruturasCliente = new EstruturasCliente (buffersImpl);
           for (int filosofo = 0; filosofo < 5; filosofo++)
            {
               new Filosofo("Filosofo_" + filosofo, estruturasCliente, filosofo).start();
            }
   
           } catch (Exception e) {
             System.out.println("ERROR : " + e) ;
             e.printStackTrace(System.out);
             }
   }
}