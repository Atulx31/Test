import java.util.ArrayDeque;
import java.util.Queue;

public class Queues{
    
    
    public static void main(String[] args) {
        Queue<Integer> cola = new ArrayDeque<>();
        Queue<Integer> cola2 = new ArrayDeque<>();

        // insertar elementos a la cola

        cola.add(1);
        cola.add(2);
        cola.add(3);
        cola.add(4);
        cola.add(5);
        cola.add(6);
        cola.add(7);

        cola2.add(1);
        cola2.add(2);
        cola2.add(3);


        //Mostrar los elementos de la cola
        System.out.println(cola); //[1, 2, 3, 4, 5, 6, 7]
 
        //Verificar que elemento está en la cabeza de la cola
        System.out.println(cola.element()); //1
 
        //Agrear otro elemento con el método offer
        cola.offer(8);
 
        //Mostrar los elementos de la cola
        System.out.println(cola); //[1, 2, 3, 4, 5, 6, 7, 8]

        // verificar el elemento en la cabeza de la cola
        System.out.println(cola.peek()); //1

        // eliminar el primer elemento de la cola con poll
        System.out.println("Elemento eliminado: " + cola.poll()); //1

         // eliminar el primer elemento de la cola con remove
        System.out.println("Elemento eliminado: " + cola.remove()); //1

         //Mostrar los elementos de la cola
        System.out.println(cola); //[3, 4, 5, 6, 7]

        // obtener el tamaño de la cola
        System.out.println("Tamaño de la cola: " + cola.size()); //6

        // obtener el primer elemento de la cola
        System.out.println("Primer elemento de la cola: " );

        // verificar si la fila esta vacia
        System.out.println(cola.isEmpty());

        // remover con condicion
        cola.removeIf(n -> n%2 == 0);
        System.out.println(cola);

        // clear
        cola.clear();
        System.out.println("Cola vacia: " + cola.isEmpty());


        // comparar
        System.out.println("Las colas son iguales: " + cola.equals(cola2));

        
    }
}