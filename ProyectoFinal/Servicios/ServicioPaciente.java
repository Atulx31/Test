package ProyectoFinal.Servicios;
import ProyectoFinal.Persistencia.RepositorioPaciente;  
import ProyectoFinal.Modelo.Paciente;

public class ServicioPaciente {
    
    RepositorioPaciente repositorioPaciente;

    public ServicioPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public String registrarPaciente(String nombre, String cedula, String telefono) {
        boolean resultado = repositorioPaciente.existePorDocumento(cedula);
        if (resultado == true) {
            return "El paciente con cédula " + cedula + " ya existe.";
        } else {
            Paciente paciente = new Paciente(nombre, cedula, telefono);
            repositorioPaciente.guardar(paciente);
            return "Paciente registrado exitosamente: ";
        }
    }

    public void validarLlenadoDatos(String nombre, String cedula, String telefono) {
        if (nombre == null || nombre.isEmpty()) {
            System.out.println("El nombre del paciente no puede estar vacío.");
        }
        if (cedula == null || cedula.isEmpty()) {
            System.out.println("La cédula del paciente no puede estar vacía.");
        }
    }

    public boolean validarSoloNumeros(String cedula){
        if (cedula.matches("\\d+")){
            return true;
        } else {
            System.out.println("La cédula debe contener solo números. Por favor, ingrese una cédula válida.");
            return false;  
        }
}

}