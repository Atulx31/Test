package Proyecto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operaciones op = new Operaciones();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nMenú:");
            System.out.println("1. Registrar buque");
            System.out.println("2. Agregar contenedor a un buque");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    op.Registrarbuque();
                    break;
                case 2:
                    op.agregarContenedorABuque();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }
}
