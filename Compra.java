import java.util.ArrayList;
import java.util.Date;

public class Compra {
  private Cliente cliente;
  private ArrayList <Producto> listaProductos;
  private int cant;
  private int numFac;
  private Date fecha;
  public Compra() {
    
    cliente = new Cliente();
    listaProductos = new ArrayList<Producto>();
    cant = 0;
    numFac = 0;
    fecha = new java.util.Date();
  }
  public void setCliente(Cliente cliente) {
    this.cliente = cliente;
  }

  public Cliente getCliente() {
    return cliente;
  }

  public void setnumFac(int numFac) {
    this.numFac = numFac;
  }
  public int getnumFac(){
    return numFac;
  }
  public void setProductos(Producto producto)
  { 
      this.listaProductos.add(producto);
   }
  public ArrayList<Producto> getProductos(){
    return listaProductos;
  }
  public Date getFecha(){
    return fecha;
  }
}

