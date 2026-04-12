package Proyecto;

import java.util.ArrayList;

public class Buque {
    public String nombre;
    Contenedor contenedores[][] = new Contenedor[10][10];

    public Buque(String nombre) {
        this.nombre = nombre;
        this.contenedores = new Contenedor[10][10];
    }

    public void agregarContenedor(Contenedor contenedor, int fila, int columna) {
        if (fila >= 0 && fila < contenedores.length && columna >= 0 && columna < contenedores[0].length) {
            contenedores[fila][columna] = contenedor;
        } else {
            System.out.println("Posición fuera de los límites del buque.");
        }
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Buque [nombre=" + nombre + "]";
    }

    

}
