package ProyectoS;

import java.util.Scanner;

public class AdmistracionPacientes {
    Paciente paciente[] = new Paciente[100];

    Scanner sc = new Scanner(System.in);
        int opcion = 0;
    
    public void registrarPaciente() {
        System.out.println("Bienvenido al sistema de gestión de pacientes");
        System.out.println("---------------------------------------------");
        System.out.println("1. registrar paciente");
        System.out.println("2. consultar paciente");
        System.out.println("3. actualizar paciente");
        System.out.println("4. eliminar paciente");
        System.out.println("0. salir");
        System.out.print("Seleccione una opción: ");
        opcion = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (opcion) {
            case 1: 
                System.out.println("\nmodulo de registro de paciente");
                System.out.print("Ingrese el nombre del paciente: ");
                String nombre = sc.nextLine();
                System.out.print("Ingrese la edad del paciente: ");
                int edad = sc.nextInt();
                System.out.print("Ingrese la cédula del paciente: ");
                int cedula = sc.nextInt();
                sc.nextLine(); // Limpiar el buffer
                validarPaciente(cedula, nombre, edad);
                for (int i = 0; i < paciente.length; i++) {
                 paciente[i] = new Paciente(nombre, edad, cedula);
                }
                break;
        
            default:
                break;
        }
    }

    public void validarPaciente(int cedula, String nombre, int edad) {
        for (int i = 0; i < paciente.length; i++) {
                    if (paciente[i].getCedula() != cedula) {
                        System.out.println("Paciente registrado exitosamente.");
                        break;
                    }
                }
    }
}
