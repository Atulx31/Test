package TallerQ;

public class Main {
     public static void main(String[] args){
        Supermercado supermercado = new Supermercado();
        supermercado.llenarCarritos();
        supermercado.llenarCajas();
        for (int i = 1; i < 10; i++){
          supermercado.agregarCliente(i);
        }

        for (int i = 0; i<3; i++){
          supermercado.pagar(i);
        }
        
     }
}
