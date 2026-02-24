package Taller;

public class Inventario {
     Producto[] prod = new Producto[5];

    public Inventario() {
        prod[0] = new Producto(1, "Laptop", 1500.00, 10);
        prod[1] = new Producto(2, "Smartphone", 800.00, 20);
        prod[2] = new Producto(3, "Tablet", 400.00, 15);
        prod[3] = new Producto(4, "Monitor", 300.00, 8);
        prod[4] = new Producto(5, "Teclado", 50.00, 25);
    }

    
}
