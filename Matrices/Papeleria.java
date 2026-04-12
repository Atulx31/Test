package Matrices;

public class Papeleria {
    
    private String distribuidora;
    private String modelo;
    private double precio;

    public Papeleria(String distribuidora, String modelo, double precio) {
        this.distribuidora = distribuidora;
        this.modelo = modelo;
        this.precio = precio;
    }

    public String getDistribuidora() {
        return distribuidora;
    }

    public void setDistribuidora(String distribuidora) {
        this.distribuidora = distribuidora;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Papeleria [distribuidora=" + distribuidora + ", modelo=" + modelo + ", precio=" + precio + "]";
    }

    public int[][] llenarMatrizPapeleria(int distribuidora, int modelo, int precio){
        int [][] m = new int[distribuidora][modelo];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++){
                m[i][j] = precio;
            }
    }
return m;

}
