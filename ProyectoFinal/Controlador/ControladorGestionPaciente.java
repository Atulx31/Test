package ProyectoFinal.Controlador;
import ProyectoFinal.Servicios.ServicioPaciente;

public class ControladorGestionPaciente {
    
    ServicioPaciente servicioPaciente;

    public ControladorGestionPaciente(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    public String registrarPaciente(String nombre, String cedula, String telefono) {
        String resultado = servicioPaciente.registrarPaciente(nombre, cedula, telefono);
        return resultado;
    }
}
