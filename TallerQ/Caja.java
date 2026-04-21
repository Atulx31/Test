package TallerQ;

import java.util.Queue;

public class Caja {
    int id;
    Queue<Cliente> fila;
    
    public Caja(int id, Queue<Cliente> fila) {
        this.id = id;
        this.fila = fila;
    }

    
}
