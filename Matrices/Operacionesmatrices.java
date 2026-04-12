package Matrices;

import java.util.Random;

public class Operacionesmatrices {
    
    public int[][] llenarMatrizAleatoria(int fila, int columnas, int min, int max){
        int [][] m = new int[fila][columnas];
        Random r = new Random();
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++){
                m[i][j] = r.nextInt(max - min + 1) + min;
            }
    }
return m;
    }

    public String mostrarMatriz(int[][] m){
        String cad = "";
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                cad += m[i][j] + " ";   
            }
            cad += "\n";
        }
            return cad;
    }

// mostrar el mayr y menor
public String mayorMenor(int[][] m){
    int mayor = m[0][0];
    int menor = m[0][0];
    for (int i = 0; i < m.length; i++){
        for (int j = 0; j<m[0].length; j++){
            if (m[i][j] > mayor){
                mayor = m[i][j];
            }
            if (m[i][j] < menor){
                menor = m[i][j];
            }
        }
    }
    return "Mayor: " + mayor + " Menor: " + menor;

    public
}

}