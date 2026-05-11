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

}