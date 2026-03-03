package Taller;

public class Inventario {
    public static void main(String[] args) {
        
    
     Producto[] prod = new Producto[10];


        prod[0] = new Producto(1, "Laptop", 1500.00, 10);
        prod[1] = new Producto(2, "Smartphone", 800.00, 20);
        prod[2] = new Producto(3, "Tablet", 400.00, 15);
        prod[3] = new Producto(4, "Monitor", 300.00, 4);
        prod[4] = new Producto(5, "Teclado", 50.00, 25);
    

// Agregar un nuevo producto al inventario
for (int i = 0; i<prod.length; i++){
if (prod[i] == null){
    prod[i] = new Producto(6, "Mouse", 30.00, 30);
    break;
            }
    

        }
for(int i = 0; i<prod.length; i++){
    System.out.println(prod[i]);
    }


    // Buscar un producto por su ID
    int idBuscado = 3;
for (int i = 0; i<prod.length; i++){
    if (prod[i] != null && prod[i].getId() == idBuscado){
        System.out.println("Producto encontrado: " + prod[i]);
    }

}


// Actualizar la cantidad en stock de un producto
int idActualizar = 3;
int nuevaCantidad = 25;
for (int i = 0; i<prod.length; i++){
    if (prod[i] != null && prod[i].getId() == idActualizar){
        prod[i].setCantidadStock(nuevaCantidad);
        System.out.println("Cantidad actualizada: " + prod[i]);
    }
}


//Generar informe valor total
double valorTotal = 0;
for (int i = 0; i<prod.length; i++){
    if (prod[i] != null){
        valorTotal += prod[i].getPrecio() * prod[i].getCantidadStock();
    }
    
}  
System.out.println("Valor total: " + valorTotal);


// Obtener producto agotados
for (int i = 0; i<prod.length; i++){
    if (prod[i] != null && prod[i].getCantidadStock() < 5){
        System.out.println("Productos agotados: " + prod[i]);
    } 
}



//ordenar por precio decendente
for (int i = 0; i < prod.length; i++) {
    Producto temp = null;
    for (int j = 0; j < prod.length - 1; j++) {
        if (prod[j] != null && prod[j + 1] != null && prod[j].getPrecio() < prod[j + 1].getPrecio()) {
            temp = prod[j];
            prod[j] = prod[j + 1];
            prod[j + 1] = temp;
        }
    }   
    System.out.println(prod[i]);
}

}
}