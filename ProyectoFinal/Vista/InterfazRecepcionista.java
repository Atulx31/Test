package ProyectoFinal.Vista;
import java.util.Scanner;
import ProyectoFinal.Controlador.ControladorGestionPaciente;
import ProyectoFinal.Servicios.ServicioPaciente;

public class InterfazRecepcionista {
    private Scanner scanner;
    ControladorGestionPaciente controladorGestionPaciente;
    ServicioPaciente servicioPaciente;

    public InterfazRecepcionista(ControladorGestionPaciente controladorGestionPaciente) {
        this.controladorGestionPaciente = controladorGestionPaciente;
        this.scanner = new Scanner(System.in);
        this.servicioPaciente = new ServicioPaciente(null); // Pasar el repositorio correspondiente
    }

    public void mostrarMenuRecepcionista() {
        int opcion;
        do {
            System.out.println("=== Menú Recepcionista ===");
        System.out.println("1. Registrar Paciente");
        System.out.println("2. Actualizar información de paciente");
        System.out.println("3. Buscar paciente por documento");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea
        switch (opcion) {
            case 1:
               MenuRegistrarPaciente();
                break;
            case 2:
                // actualizarPaciente();
                break;
            case 3:
                // buscarPacientePorDocumento();
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida. Intente nuevamente.");
        }
        } while (opcion != 0);
        
    }

    private void MenuRegistrarPaciente() {
        System.out.println("=== Registrar Paciente ===");
        System.out.print("Ingrese el nombre del paciente: ");

        String nombre = scanner.nextLine();
        

        System.out.print("Ingrese la cédula del paciente (sin puntos ni comas): ");
        String cedula = scanner.nextLine();
       

        System.out.print("Ingrese el teléfono del paciente: ");
        String telefono = scanner.nextLine();

        if (!servicioPaciente.validarDatos(nombre, cedula, telefono)){
            return;
        }
        

        String resultado = controladorGestionPaciente.registrarPaciente(nombre, cedula, telefono);
        System.out.println(resultado);
    }
}