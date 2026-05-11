package semana12;

import java.util.*;


public class PracticaMapsAndList {
    public static void main(String[] args) {
        
        LinkedList<String> historialNavegacion = new LinkedList<>();
        historialNavegacion.add("google.com");
        historialNavegacion.add("github.com");
        historialNavegacion.add("stackoverflow.com");

        System.out.println(historialNavegacion.getLast()); // devuelve "stackoverflow.com"

        System.out.println(historialNavegacion.removeLast()); // devuelve "stackoverflow.com"

        System.out.println(historialNavegacion); 

        for(String pagina: historialNavegacion){
            System.out.println(pagina);
        }


        //-------------------------------------------------------------------

        Map<Integer, String> productos = new HashMap<>();
        productos.put(101, "Laptop"); 
        productos.put(102, "Mouse"); 
        productos.put(103, "Teclado");

        System.out.println(productos);
        
        System.out.println(productos.containsKey(102));

        productos.put(101, "pantalla");

        System.out.println(productos);

        productos.forEach((key, value) -> {
            System.out.println("Codigo: " + key + ", Producto: " + value);
        });


        //-------------------------------------------------------------------

        LinkedList<String> ropa = new LinkedList<>();
        LinkedList<String> calzado = new LinkedList<>();

        ropa.add("camisa");
        ropa.add("pantalon");

        calzado.add("zapatos");

        Map <String, LinkedList<String>> pedidos = new HashMap<>();
        pedidos.put("Ana", ropa);
        pedidos.put("Luis", calzado);

        System.out.println("cantidad de productos " + ropa.size());
        System.out.println(calzado.add("tenis"));

        System.out.println(pedidos);

        
    }
}