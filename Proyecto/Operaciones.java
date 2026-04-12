package Proyecto;

import java.util.Arrays;
import java.util.Scanner;

public class Operaciones {
    
    Scanner sc = new Scanner(System.in);
    Buque buques[] = new Buque[10];




    public void Registrarbuque(){
            System.out.println("Ingrese el nombre del buque: ");
            String nombre = sc.nextLine();
            for (int i = 0; i < buques.length; i++) {
            if (buques[i] == null) {
                    buques[i] = new Buque(nombre);
                    System.out.println("Buque registrado en posición " + i);
                    return;
                }
        }
    }

    public void listarBuques() {
        System.out.println("Buques registrados:");
        for (int i = 0; i < buques.length; i++) {
            if (buques[i] != null) {
                System.out.println((i + 1) + ". " + buques[i].getNombre());
            }
        }
    }

    public Buque seleccionarBuque() {
        listarBuques();
        System.out.println("Ingrese el número del buque al que desea agregar contenedores: ");
        int indice = sc.nextInt() - 1;
        sc.nextLine();
        if (indice >= 0 && indice < buques.length && buques[indice] != null) {
            return buques[indice];
        } else {
            System.out.println("Selección inválida.");
            return null;
        }
    }

    public void agregarContenedorABuque() {
        Buque buqueSeleccionado = seleccionarBuque();
        if (buqueSeleccionado != null) {
            System.out.println("Ingrese el código del contenedor: ");
            String codigo = sc.nextLine();
            System.out.println("Ingrese el peso del contenedor: ");
            double peso = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el origen del contenedor: ");
            String origen = sc.nextLine();
            Contenedor contenedor = new Contenedor(codigo, peso, origen);

            System.out.println("Ingrese la fila (0-9): ");
            int fila = sc.nextInt();
            System.out.println("Ingrese la columna (0-9): ");
            int columna = sc.nextInt();
            sc.nextLine();

            buqueSeleccionado.agregarContenedor(contenedor, fila, columna);
            System.out.println("Contenedor agregado al buque " + buqueSeleccionado.getNombre());
        }
    }

    

}


    
    
    

