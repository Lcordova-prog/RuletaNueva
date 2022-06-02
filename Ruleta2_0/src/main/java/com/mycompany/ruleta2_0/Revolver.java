package com.mycompany.ruleta2_0;

public class Revolver {

    Nodo r;
 // Se encarga de crear la lista circular 
    public Revolver() {
        this.r = new Nodo();
        Nodo aux = this.r;
        //Creo un ciclo for para que me cree 5 nodos en una lista circular
        for (int i = 0; i < 5; i++) {
            aux.siguiente = new Nodo();
            aux = aux.siguiente;

        }
        //Se une la lista en el punto inicial y final
        aux.siguiente = this.r;
        cargarBala();
    }

    public final void cargarBala() {
        int x = (int) Math.floor((Math.random() * 6) + 1);
        Nodo aux = this.r;
        for (int i = 0; i < x; i++) {
            aux = aux.siguiente;
        }
        aux.bala = true;
    }

    public void balaRecarga() {
        Nodo aux = this.r;
        for (int i = 0; i < 6; i++) {
            aux.bala = false;
            aux = aux.siguiente;
        }
        cargarBala();
    }

    public boolean Fuego() {
        boolean Ruedita = this.r.bala;
        if (Ruedita) {
         balaRecarga();
        } else {
            this.r = this.r.siguiente;
        }
        return Ruedita;
    }

   

}
