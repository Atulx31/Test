package Semana2;

public class Ejercicio1 {
    public static void main(String[] args) {
        int []a={4,8,9,6,1,2};
        int pares = 0;
        int impares = 0;

        //iterar los elementos del arreglo
        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);

            //suma los números pares e impares
            if (a[i] % 2 == 0) {
                pares += a[i];
            } else {
                impares += a[i];
            }
        }
        System.out.println("Suma de números pares: " + pares);
        System.out.println("Suma de números impares: " + impares);  
        
        //Forma 2

        int []v = new int[10];
        }
    }

