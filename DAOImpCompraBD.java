import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.SimpleDateFormat;
import java.text.ParseException;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Date;

public class DAOImpCompraBD implements DAOCompra {

  private Connection con;

  public DAOImpCompraBD() {
    try {
      con = DriverManager.getConnection("jdbc:sqlite:tienda.db");
    } catch (SQLException e) {
       System.out.println(e.getMessage());
    }
  }

  public void grabar (Compra compra) {
    String sql = "INSERT INTO compra (Factura,Sku,Dni,Fecha,Unidades) VALUES(?,?,?,?,?)";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    String fechaComoCadena = sdf.format(compra.getFecha());
    try{
      PreparedStatement pstmt = con.prepareStatement(sql);
      for (Producto key : compra.getComprado().keySet()) {
        pstmt.setInt(1, compra.getNumFac());
        pstmt.setInt(2, key.getSku());
        pstmt.setString(3, compra.getCliente().getDni());
        pstmt.setString(4, fechaComoCadena);
        pstmt.setDouble(5, compra.getComprado().get(key));
        pstmt.executeUpdate();
      }
      System.out.println("Insertado en la DB ");
    } catch (SQLException e) {
      System.out.println("***" + e.getMessage() + "***");
    }
  }

  public int enumerar() { // Modificar
    String sql="SELECT MAX(Factura) FROM compra";
    int numFac = 0;
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      numFac = rs.getInt("Factura")+1;
    } catch (SQLException e) {
      System.out.println("***" + e.getMessage() + "1***");
    } 
    return numFac;
  }

  public Compra ticket (int numFac) {
    Compra compra = null;
    Cliente cliente = null;
    Producto producto= null;
    Map<Producto,Double> comprado= new HashMap<Producto,Double>();
    String sql = "SELECT A.Sku,P.Dni,Fecha,Unidades,Name,Precio,Cantidad,Nombre,Direccion FROM compra C, albaran A, cliente P WHERE Factura ="+numFac+" AND A.Sku = C.Sku AND C.Dni = P.Dni";
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(sql);
      cliente=new Cliente(rs.getString("Dni"),rs.getString("Nombre"),rs.getString("Direccion"));
      SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
      Date fecha = sdf.parse(rs.getString("Fecha"));
      while (rs.next()) {
        producto = new Producto(rs.getInt("Sku"),rs.getString("Name"),rs.getDouble("Precio"),rs.getDouble("Cantidad"));
        comprado.put(producto,rs.getDouble("Unidades"));
      }
      compra = new Compra(cliente,comprado,numFac,fecha);
      
    } catch (SQLException e) {
      System.out.println("***" + e.getMessage() + "1***");
    } catch (ParseException e) {
        e.printStackTrace();
      }
    return compra;
  }
/*

  public List<Compra> allTicketCliente (String dni) {
    Compra compra = null;
    Cliente cliente;
    Producto producto;
    Map<Producto,double> comprado;
    List<Compra> allticket = new ArrayList<Compra>();
    String sqlCliente = "SELECT Dni, Nombre, Direccion FROM cliente WHERE Dni = '"+dni+"'"; // para conseguir datos de la tabla Cliente
    String sqlProductos = "SELECT A.Sku, Nombre, Precio, Cantidad, Unidades FROM compra C, albaran A WHERE dni ="+dni; // Conseguir los datos de los productos y unidades compradas para generar el Map<Producto,Double>
    String sqlFecha = "SELECT Factura, Fecha FROM compra WHERE Dni ="+dni;
    try {
      Statement stmt = con.createStatement();
      ResultSet rs = stmt.executeQuery(sqlCliente);
      cliente = new Cliente(rs.getString("Nombre"),rs.getString("Dni"),rs.getString("Direccion"));
      ResultSet rs = stmt.executeQuery(sqlProductos);
      while (rs.next()) {
        producto = new Producto(rs.getInt("Sku"),rs.getString("Name"),rs.getDouble("Precio"), rs.getDouble("Cantidad"));
        comprado.put(producto,rs.getDouble("Unidades"));
      }
      ResultSet rs = stmt.executeQuery(sqlFecha);
      compra = new Compra(cliente,comprado,rs.getInt("Factura"),rs.getDate("Fecha"));
    } catch (SQLException e) {
      System.out.println("***" + e.getMessage() + "***");
    }
    return allTicket;
  }

  public List<Compra> allTicket () {

  }
*/
  public void cerrar() {
    try {
      con.close();
    } catch (SQLException e) {
       System.out.println(e.getMessage());
    }  
  }
}