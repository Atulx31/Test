import java.util.Stack;

public class Stacks {
    
    public static void main(String[] args) {

        Stack<String> pila = new Stack<>();

        System.out.println(pila.empty());
        
        //Insetar elementos a la pila

        pila.push("Mary Jane");
        pila.push("Dalmar");
        pila.push("Samuel");
        pila.push("Yolian");
        

        // mostrar pila
        System.out.println(pila);

        // mostrar el ultimo elemento de la pila sin eliminar el elemento
        System.out.println(pila.peek()); // Yolian

        // eliminar el ultimo elemento de la pila
        System.out.println("Elemeto eliminado: " + pila.pop());

        //busqueda
        System.out.println("Buscar: " + pila.search("Samuel"));

        System.out.println("Buscar: " + pila.search("Dalmar"));

        System.out.println("Buscar: " + pila.search("Mary Jane"));

        // obtener el ultimo elemento de la pila. to element
        System.out.println("el ultimo elemento de la pila: " + pila.lastElement());

        // to array
        System.out.println("Convertido a array: " + pila.toArray());

        //imprimir clone
        System.out.println("Pila original " + pila + "-  Pila clonada: " + pila.clone());   
        
        // tamaño de la pila
        System.out.println("Tamaño de la pila: " + pila.size());



    }
}
