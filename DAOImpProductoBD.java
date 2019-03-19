import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.List;
import java.util.ArrayList;

public class DAOImpProductoBD implements DAOProducto{

	private Connection con;

	public DAOImpProductoBD(){
		try {
      con = DriverManager.getConnection("jdbc:sqlite:tienda.db");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
	}

  public DAOImpProductoBD(String conexion){ // Para cualquier conexion p.ej con mysql
    try {
      con = DriverManager.getConnection(conexion);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

	public List<Producto> leerTodos(){
		Producto producto;
		List<Producto> albaran = new ArrayList<Producto>();
		String sql = "SELECT Sku, Name, Precio, Cantidad FROM albaran";
      try{
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
        	producto = new Producto(rs.getInt("Sku"),rs.getString("Name"),rs.getDouble("Precio"),rs.getDouble("Cantidad"));
        	albaran.add(producto);
        }
      } catch (SQLException e) {
        System.out.println(e.getMessage());
      }
    return albaran;
	}

	public void grabar(Producto producto) {
		String sql = "INSERT INTO albaran(Sku,Name,Precio,Cantidad) VALUES(?,?,?,?)";
    try{
      PreparedStatement pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, producto.getSku());
      pstmt.setString(2, producto.getName());
      pstmt.setDouble(3, producto.getPrecio());
      pstmt.setDouble(4, producto.getCantidad());
      pstmt.executeUpdate();
      System.out.println("Insertado producto en la DB ");
    } catch (SQLException e) {
      System.out.println("***" + e.getMessage() + "***");
    }
	}

	public void cerrar() {
    try {
      con.close();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }  
  }
}