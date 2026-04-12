package Proyecto;

public class Contenedor {
     private String codigo;
    private double peso;
    private String origen;

    public Contenedor(String codigo, double peso, String origen) {
        this.codigo = codigo;
        this.peso = peso;
        this.origen = origen;
    }

    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getOrigen() {
        return origen;
    }

    @Override
    public String toString() {
        return "Contenedor{" +
                "codigo='" + codigo + '\'' +
                ", peso=" + peso +
                ", origen='" + origen + '\'' +
                '}';
    }
}
