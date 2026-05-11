package ProyectoFinal.Persistencia;

import java.util.List;
import java.util.ArrayList;
import ProyectoFinal.Modelo.Paciente;

public class RepositorioPaciente {

    private List<Paciente> pacientes;

    public RepositorioPaciente() {
        this.pacientes = new ArrayList<>();
    }

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

    
}