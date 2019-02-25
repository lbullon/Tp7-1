import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class DAOImpCompraSerialized implements DAOCompra {
    private FileOutputStream outFile; 
    private ObjectOutputStream out; 

    public DAOImpCompraSerialized() {
        try {
        outFile = new FileOutputStream("datos.dat");
        out = new ObjectOutputStream(outFile);
        }
         catch (IOException e) {
        //TODO: handle exception
    }

    }


    public void grabar(Compra c){

        try {
            
            out.writeObject(c);
            //out.close();
        } catch (IOException e) {
            //TODO: handle exception
        }

    }

}