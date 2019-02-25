class Producto {

    private int peso;
    private String name;
    private double precio;
    public Producto() {
         peso = 0;

         name = "";
         precio = 0;
         
    }
    public Producto( int peso, String name, double precio) {
        this.peso = peso;
        this.name = name;
        this.precio = precio;
   
      
    }
    public void setPeso(int p) {
      peso = p;
    }
    public int getPeso() {
      return peso;
    }

    public void setName(String n) {
      name = n;
    }
    public String getName() {
      return name;
    }
    public void setPrecio(double pr) {
      precio = pr;
    }
    public double getPrecio() {
      return precio;
    }


}
