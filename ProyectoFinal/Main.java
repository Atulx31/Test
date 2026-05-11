package ProyectoFinal;
import ProyectoFinal.Persistencia.RepositorioPaciente;
import ProyectoFinal.Servicios.ServicioPaciente;
import ProyectoFinal.Vista.InterfazRecepcionista;
import ProyectoFinal.Controlador.ControladorGestionPaciente;

public class Main {
    public static void main(String[] args) {
        //capa de persistencia
        RepositorioPaciente repositorioPaciente = new RepositorioPaciente();
        //capa de servicios
        ServicioPaciente servicioPaciente = new ServicioPaciente(repositorioPaciente);
        //capa de controlador
        ControladorGestionPaciente controladorGestionPaciente = new ControladorGestionPaciente(servicioPaciente);
        //capa de vista
        InterfazRecepcionista interfazRecepcionista = new InterfazRecepcionista(controladorGestionPaciente);
        interfazRecepcionista.mostrarMenuRecepcionista();
    }
}

  