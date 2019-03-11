import java.util.List;
import java.util.ArrayList;
import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Date;

public class App {
   public static void main(String args[]) {
    DAOCompraTxt txt = new DAOCompraTxt();
    
    Cliente cliente = null;
    String input;
    String line = null;
	Console console = null;
    console = System.console();
    Compra una_compra = new Compra();
    System.out.println(" Name: ? ");
    input = console.readLine();
    cliente.setNombre(input);
    DAOImpCompraSerialized sr = new DAOImpCompraSerialized();
    

    if (console != null)
     {
        
        while(true) {
			
		  Producto producto = new Producto();

          System.out.println(" Que fruta quieres: ? ");
          input = console.readLine();
		   producto.setName(input);
	      System.out.println(" Cantidad de " + producto.getName() + ": ? ");
          input = console.readLine();
          int peso = Integer.parseInt(input);
          producto.setPeso(peso);
          una_compra.setProductos(producto);
          System.out.println(" Otra entrada? [s/n]: ");
          if(console.readLine().equals("n")){
               txt.grabar(una_compra);
               sr.grabar(una_compra);
               break;
            }
        
             
        }
      
     }
     
}

}