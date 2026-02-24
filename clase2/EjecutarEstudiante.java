public class EjecutarEstudiante {

        public static void main(String[] args) {
            
        Estudiante objE = new Estudiante();
        Estudiante[] est = new Estudiante[7];
        
        
        est [0] = new Estudiante("Juan",3, "ingenieria", 4.5, 18);
        est [1] = new Estudiante("María", 5, "Derecho", 4.8, 22);
        est [2] = new Estudiante("Carlos", 7, "Medicina", 4.2, 19);
        est [3] = new Estudiante("Ana", 4, "Arquitectura", 4.7      , 21);
        est [4] = new Estudiante("Pedro", 1, "Psicología", 4.3, 20);
        est [5] = new Estudiante("Sofía", 6, "Ingeniería de Sistemas", 4.9, 23);
        est [6] = new Estudiante("Luis", 6, "Ingeniería de Sistemas", 4.6, 18);
        
        //imprimir el nombre y programa de cada estudiante
        // for (int i = 0; i < est.length; i++){
        // System.out.println(est[i].getNombre() + " -> " + est[i].getPrograma());
        // }

        
        double sumarNotas = 0.0;
        int k =0;
        for (int i = 0; i < est.length; i++){
    if (est[i].getSemestre() == 6 && est[i].getPrograma().equals("Ingeniería de Sistemas")){
        System.out.println(est[i].getNombre() + " -> " + est[i].getSemestre() + " -> " + est[i].getPrograma());
        sumarNotas += est[i].getNotaPromedio();
        k++;
    }
}
if (k == 0) {
    System.out.println("No se encontraron estudiantes de Ingeniería de Sistemas en el semestre 6.");
} else {
    System.out.println("Promedio de notas: " + (sumarNotas/k));
}
        //estudiantes menores de 3 semestre
        // double sumarNotas = 0.0;
        //  for (int i = 0; i < est.length; i++){
        //  if (est[i].getSemestre() == 6){
        //     System.out.println(est[i].getNombre() + " -> " + est[i].getSemestre());
        //     sumarNotas += est[i].getNotaPromedio();
        //     System.out.println(sumarNotas/est.length);
        // }
        
        
        //  }
        }

        // // obtener edad promedio de los estudiantes
        // int[] edades = new int [est.length];
        // for (int i = 0 ; i < edades.length; i++){
        //     edades[i] += est[i].getEdad();
        // }


        // System.out.println(objE.calcularPromedio(edades));
    }


