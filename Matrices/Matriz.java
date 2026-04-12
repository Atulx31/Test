package Matrices;

public class Matriz {
    
    public static void main(String[] args) {

        Operacionesmatrices op = new Operacionesmatrices();
        Papeleria[][] papeleria = new Papeleria[5][5];

        
        // creacion de una matriz forma 1|
        int[][] m1 = {
            {9, 4, 1},
            {2, 8, 7},
            {3, 5, 6}
        };

        // creacion de una matriz forma 2
        // int[][] m2 = new int[3][3];
        // m2[0][0] = 9;
        // m2[0][1] = 4;

        // recorrer y mostrar una matriz
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                System.out.println ("m1["+ i +"]["+ j +"]="+ m1[i][j] );
            }
        }

        // recorrer y mostrar una matriz
        String cad = "";
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                cad += m1[i][j] + " ";   
            }
            cad += "\n";
        }
            System.out.println(cad);

            // operaciones con matrices
            int[][] m = op.llenarMatrizAleatoria(5, 5, 1, 9);
            System.out.println(op.mostrarMatriz(m));
            System.out.println(op.mayorMenor(m));
    }
}
