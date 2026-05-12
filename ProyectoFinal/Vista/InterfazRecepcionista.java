package ProyectoFinal.Vista;

import ProyectoFinal.Controlador.ControladorGestionPaciente;
import ProyectoFinal.Modelo.Paciente;
import java.util.Scanner;

public class InterfazRecepcionista {

    private final Scanner scanner;
    private final ControladorGestionPaciente controladorGestionPaciente;

    public InterfazRecepcionista(
            ControladorGestionPaciente controladorGestionPaciente) {

        this.controladorGestionPaciente = controladorGestionPaciente;

        this.scanner = new Scanner(System.in);
    }

    public void mostrarMenuRecepcionista() {

        int opcion;

        do {

            System.out.println("\n=== MENÚ RECEPCIONISTA ===");
            System.out.println("1. Registrar paciente");
            System.out.println("2. Actualizar paciente");
            System.out.println("3. Buscar paciente");
            System.out.println("0. Salir");

            System.out.print("Seleccione una opción: ");

            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {

                case 1:
                    registrarPaciente();
                    break;

                case 2:
                    actualizarPaciente();
                    break;

                case 3:
                    buscarPaciente();
                    break;

                case 0:
                    System.out.println("Saliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 0);
    }

    private void registrarPaciente() {

        System.out.println("\n=== REGISTRAR PACIENTE ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Cédula: ");
        String cedula = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        String resultado = controladorGestionPaciente.registrarPaciente(nombre, cedula, telefono);

        System.out.println(resultado);
    }

    private void actualizarPaciente() {

        System.out.println("\n=== ACTUALIZAR PACIENTE ===");

        System.out.print("Cédula del paciente: ");
        String cedula = scanner.nextLine();

        System.out.print("Nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();

        System.out.print("Nuevo teléfono: ");
        String nuevoTelefono = scanner.nextLine();

        String resultado = controladorGestionPaciente.actualizarPaciente(cedula, nuevoNombre, nuevoTelefono);

        System.out.println(resultado);
    }

    private void buscarPaciente() {

        System.out.println("\n=== BUSCAR PACIENTE ===");

        System.out.print("Ingrese la cédula: ");

        String cedula = scanner.nextLine();

        Paciente paciente = controladorGestionPaciente
                .buscarPacientePorDocumento(
                        cedula);

        if (paciente == null) {

            System.out.println("Paciente no encontrado.");
            return;
        }

        System.out.println("\nPaciente encontrado:");
        System.out.println(paciente);
    }

}