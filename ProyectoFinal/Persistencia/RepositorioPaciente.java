package ProyectoFinal.Persistencia;

import ProyectoFinal.Modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPaciente {

    private final List<Paciente> pacientes = new ArrayList<>();

    public boolean existePorDocumento(String documento) {

        for (Paciente paciente : pacientes) {

            if (paciente.getCedula().equals(documento)) {
                return true;
            }
        }

        return false;
    }

    public void guardar(Paciente paciente) {
        pacientes.add(paciente);
    }

    public Paciente buscarPorDocumento(String documento) {

        for (Paciente paciente : pacientes) {

            if (paciente.getCedula().equals(documento)) {
                return paciente;
            }
        }

        return null;
    }

    public List<Paciente> listarPacientes() {
        return pacientes;
    }
}