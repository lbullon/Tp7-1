import java.util.Map;
import java.util.HashMap;

public class Pruebas {
	public static void main(String[] args) {
		DAOCompra dao = new DAOImpCompraBD();
		DAOProducto dao2 = new DAOImpProductoBD();
		DAOCliente dao3 = new DAOImpClienteBD();
		Map<Producto,Double> comprado = new HashMap<Producto,Double>();
		Map<Producto,Double> comprado1 = new HashMap<Producto,Double>();
		/*Producto p1 = new Producto(11111,"manzana",1.4,200);
		dao2.insertar(p1);
		Producto p2 = new Producto(11112,"fresa",2.5,200);
		dao2.insertar(p2);
		Producto p3 = new Producto(11113,"pera",1.8,200);
		dao2.insertar(p3);
		Producto p4 = new Producto(11114,"limon",1.7,200);
		dao2.insertar(p4);
		Producto p5 = new Producto(11115,"naranja",1.5,200);
		dao2.insertar(p5);
		Producto p6 = new Producto(11116,"melocoton",2.0,200);
		dao2.insertar(p6);
		Cliente cliente = new Cliente("Pepe","47532233B","Calle Falsa 21");
		Cliente cliente2 = new Cliente("Maria","47532231B","Calle Falsa 22");
		dao3.alta(cliente);
		dao3.alta(cliente2);
		comprado.put(p1,1.2);
		comprado.put(p2,2.0);
		comprado1.put(p2,3.1);
		Compra compra1 = new Compra(cliente2,comprado1,1);
		comprado.put(p3,3.1);
		comprado.put(p4,2.0);
		comprado.put(p5,1.5);
		comprado.put(p6,1.2);
		Compra compra = new Compra(cliente,comprado,2);
		System.out.println(compra.toString());
		System.out.println(compra1.toString());
		dao.grabar(compra);
		dao.grabar(compra1);*/
		Compra c = dao.ticket(2);
		Compra c1 = dao.ticket(1);
		System.out.println(c.toString());
		System.out.println(c1.toString());
		dao.cerrar();


	}
}