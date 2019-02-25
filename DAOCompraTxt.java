import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;

public class DAOCompraTxt implements DAOCompra{    
    public  DAOCompraTxt(){
   
    }
    public void grabar(Compra c){
        String datos = "";
        datos += c.getnumFac() + ":" + c.getFecha() + "|";
        datos += c.getPer().getName() + ":" + "|";
        for(Producto producto : c.getProductos()){
            datos += producto.getName() + ":" + producto.getPeso()+ "|";

        }
        datos += "\n";
        try{

            File file = new File("fileAulas69.txt");
            FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
            BufferedWriter bw = new BufferedWriter(fw);
            if(file.exists() != false){
                
                
                bw.write(datos);
                bw.close();
                
            }
            else{
                file.createNewFile();
                
                bw.write(datos);
                bw.close();
               
    
            }
            
            }catch (Exception e)
            {
                e.printStackTrace();
            }  

    }
    public void leer (String url){
        
    }
}