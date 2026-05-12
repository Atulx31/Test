package ProyectoFinal.Controlador;

import ProyectoFinal.Modelo.Paciente;
import ProyectoFinal.Servicios.ServicioPaciente;

import java.util.List;

public class ControladorGestionPaciente {

    private final ServicioPaciente servicioPaciente;

    public ControladorGestionPaciente(ServicioPaciente servicioPaciente) {
        this.servicioPaciente = servicioPaciente;
    }

    public String registrarPaciente(String nombre, String cedula, String telefono) {
        try {
            return servicioPaciente.registrarPaciente(nombre, cedula, telefono);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public String actualizarPaciente(String cedula, String nuevoNombre, String nuevoTelefono) {

        try {
            return servicioPaciente.actualizarPaciente(cedula, nuevoNombre, nuevoTelefono);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }

    public Paciente buscarPacientePorDocumento(String cedula) {
        try {
            return servicioPaciente.buscarPacientePorDocumento(cedula);

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Paciente> listarPacientes() {
        return servicioPaciente.listarPacientes();
    }
}