public class Cliente {
	private String nombre;
	private String dni;
	private String direccion;

	public Cliente() {

	}

	public String getNombre() {
		return nombre;
	}
	public String getDni(){
		return dni;
	}
	public String getDireccion(){
		return direccion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String toString() {
		return String cadena = "Cliente: "+nombre+" "+dni+" "+direccion;
	}
}