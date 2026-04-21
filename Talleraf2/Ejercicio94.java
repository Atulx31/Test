import java.util.Scanner;
import java.util.Stack;

public class Ejercicio94{


    private int n = 5;
    private int numI;
    private int numJ;

    private Stack<Integer>[] pila = new Stack[n];

    public void LlenarPila(){
    for(int i = 0; i < pila.length; i++){
        pila[i] = new Stack<>();
    }
}

    public void Ejecutar(){
    LlenarPila();

    Scanner sc = new Scanner(System.in);
    
    System.out.println("Ingrese el primer numero entero");
        numI = sc.nextInt();
        

    while(Math.abs(numI)>=1 && Math.abs(numI)<=n){

            System.out.println("Ingrese el segundo numero entero");
        numJ = sc.nextInt();

        if (numI > 0){
            pila[numI-1].push(numJ);
        }

        if (numI < 0){
            pila[Math.abs(numI)-1].pop();
        }

        for (int i = 0; i<pila.length; i++){
        System.out.println("Pila " + (i+1) + ": " + pila[i]);
    }

    System.out.println("Ingrese el primer numero entero");
        numI = sc.nextInt();
    }

    for (int i = 0; i<pila.length; i++){
        System.out.println("Pila " + (i+1) + ": " + pila[i]);
    }
    
    sc.close();
    }

}




