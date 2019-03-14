import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class Pruebas2 {
	public static void main(String[] args) {
		DAOCompra dao = new DAOImpCompraBD();
		DAOProducto dao2 = new DAOImpProductoBD();
		DAOCliente dao3 = new DAOImpClienteBD();
		List<Producto> albaran = null;
		Map<Producto,Double> comprado= new HashMap<Producto,Double>();
		Cliente cliente = null;
		Producto producto = null;
		Compra compra = null;
		int numFac = 0;
		Scanner sc = new Scanner(System.in);
		boolean clienteComprando = true;
		boolean tiendaAbierta = true;
									
									/*TEXTO DE BIENVENIDA*/
		System.out.println("\n********Bienvenido a la Fruteria Pepe********\nHoy tenemos a la venta los siguientes artículos:\n");
    albaran = dao2.leerTodos();
    for (Producto p : albaran){
    	System.out.println(p);
    }

    			/*VENTA*/
    while (tiendaAbierta){
	    System.out.println("\n****Datos de cliente*****"); 
			System.out.print("Nombre: ");
			cliente = new Cliente();
			cliente.setNombre(sc.nextLine());
			System.out.print("Dni: ");
			cliente.setDni(sc.nextLine());
			System.out.print("Direccion: ");
			cliente.setDireccion(sc.nextLine());
			dao3.grabar(cliente);
			while(clienteComprando) {
				System.out.print("Producto: ");
				String nombreProducto = sc.nextLine();
				System.out.print("Cantidad: ");
				double cantidad = Double.parseDouble(sc.nextLine()); 
				for (Producto p : albaran){
	    		if (p.getName().equalsIgnoreCase(nombreProducto)){
	    			comprado.put(p,cantidad);
	    		}
	    	}
	    	System.out.println("Algo mas?S/N");
	    	if(sc.nextLine().equalsIgnoreCase("n")){
	    		clienteComprando = false;
	    	}
	    }	
	    numFac = dao.enumerar();
	    compra = new Compra(cliente,comprado,numFac);
	    dao.grabar(compra);
	    System.out.println("Tienda Abierta?S/N");
	    	if(sc.nextLine().equalsIgnoreCase("n")){
	    		tiendaAbierta = false;
	    	}
	  }

    System.out.println(dao.ticket(7));
    System.out.println(dao.ticket(8));
	}
}