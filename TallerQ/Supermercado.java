package TallerQ;

import java.util.ArrayDeque;
import java.util.Queue;

public class Supermercado {

    Queue<Carrito> carritos = new ArrayDeque<>(25);
    Caja[] cajas = new Caja[3];
    
    public void llenarCarritos(){
        for(int i = 1; i<25;i++){
            carritos.add(new Carrito(i));
        }
    }

    public void llenarCajas(){
        for(int i = 0; i<cajas.length; i++){
            cajas[i] = new Caja(i, new ArrayDeque<>());
        }
    }

    public void agregarCliente(int id){
        Cliente cliente = new Cliente(id, carritos.poll());
        Caja cajaM = cajas[0];
        for(int i = 1; i<cajas.length; i++){
            if(cajas[i].fila.size() < cajaM.fila.size()){
                cajaM = cajas[i];
            }
        }
        cajaM.fila.add(cliente);
        System.out.println("Cliente " + cliente.id + " se dirige a la caja " + (cajaM.id+1) + " con el carrito " + cliente.carrito.id);
    }

    public void pagar(int numCaja){
        Cliente cliente = cajas[numCaja].fila.poll();
        carritos.offer(cliente.carrito);
        System.out.println("Cliente " + cliente.id + " ha pagado y devuelve el carrito " + cliente.carrito.id + " a la cola de carritos");
    }
}
