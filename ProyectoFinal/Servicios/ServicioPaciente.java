package ProyectoFinal.Servicios;

import ProyectoFinal.Modelo.Paciente;
import ProyectoFinal.Persistencia.RepositorioPaciente;

import java.util.List;

public class ServicioPaciente {

    private final RepositorioPaciente repositorioPaciente;

    public ServicioPaciente(RepositorioPaciente repositorioPaciente) {
        this.repositorioPaciente = repositorioPaciente;
    }

    public String registrarPaciente(String nombre, String cedula, String telefono) {

        validarDatosPaciente(nombre, cedula, telefono);

        if (repositorioPaciente.existePorDocumento(cedula)) {
            return "El paciente con cédula " + cedula + " ya existe.";
        }

        Paciente paciente = new Paciente(nombre, cedula, telefono);
        repositorioPaciente.guardar(paciente);
        return "Paciente registrado exitosamente.";
    }

    public String actualizarPaciente(String cedula, String nuevoNombre, String nuevoTelefono) {

        validarDatosPaciente(nuevoNombre, cedula,  nuevoTelefono);

        Paciente paciente = repositorioPaciente.buscarPorDocumento(cedula);

        if (paciente == null) {
            return "El paciente no existe.";
        }

        paciente.setNombre(nuevoNombre);
        paciente.setTelefono(nuevoTelefono);

        return "Paciente actualizado correctamente.";
    }

    public Paciente buscarPacientePorDocumento(String cedula) {
        validarCedula(cedula);

        return repositorioPaciente.buscarPorDocumento(cedula);
    }

    public List<Paciente> listarPacientes() {
        return repositorioPaciente.listarPacientes();
    }

    private void validarDatosPaciente(String nombre, String cedula, String telefono) {

        StringBuilder errores = new StringBuilder();

        if (nombre == null || nombre.trim().isEmpty()) {

            errores.append(
                    "- El nombre no puede estar vacío.\n");
        }

        if (cedula == null || cedula.trim().isEmpty()) {

            errores.append(
                    "- La cédula no puede estar vacía.\n");

        } else if (!cedula.matches("\\d+")) {

            errores.append(
                    "- La cédula debe contener solo números.\n");
        }

        if (telefono == null || telefono.trim().isEmpty()) {

            errores.append(
                    "- El teléfono no puede estar vacío.\n");
        }

        if (errores.length() > 0) {
            throw new IllegalArgumentException(
                    errores.toString());
        }
    }


    private void validarCedula(String cedula) {

        if (cedula == null || cedula.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "La cédula no puede estar vacía.");
        }

        if (!cedula.matches("\\d+")) {
            throw new IllegalArgumentException(
                    "La cédula debe contener solo números.");
        }
    }
}
