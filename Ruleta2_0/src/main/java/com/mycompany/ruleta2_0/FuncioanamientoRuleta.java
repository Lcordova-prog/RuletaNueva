package com.mycompany.ruleta2_0;

public class FuncioanamientoRuleta {

   

    class Participantes {

        String nombre;
        String apellido;

        Participantes(String nombre, String apellido) {
            this.nombre = nombre;
            this.apellido = apellido;
        }

    }
     class nodo {

        Participantes jugadores;
        Revolver revolver;
        nodo siguiente;

        nodo(Participantes jugadores) {
            this.jugadores = jugadores;
            this.revolver = new Revolver();
            this.siguiente = null;
        }

    }
    nodo iniciar;
    int numparticipantes;
    String eliminados;
    String Ganador;
    String RegistroRueda;

    public FuncioanamientoRuleta(String dato) {
        this.eliminados = "";
        this.Ganador = "";
        this.RegistroRueda = "";
        this.numparticipantes = 0;
        String[] players = dato.split("\n");
        String[] apo;
        for (String juga : players) {
            apo = juga.split(" ");
            IntroducirParticipantes(new nodo(new Participantes(apo[0], apo[1])));
            numparticipantes++;

        }

    }

    private void IntroducirParticipantes(nodo nodo1) {
        if (this.iniciar == null) {
            this.iniciar = nodo1;
            this.iniciar.siguiente = nodo1;

        } else {
            nodo aux = iniciar;
            while (aux.siguiente != iniciar) {
                aux = aux.siguiente;

            }
            aux.siguiente = nodo1;
            nodo1.siguiente = iniciar;

        }

    }

    public void ApretarGatillo() {
        System.out.println("El jugador  " + this.iniciar.jugadores.nombre
                + " " + this.iniciar.jugadores.apellido + "  apunta a  " + iniciar.siguiente.jugadores.nombre
                + "  " + this.iniciar.siguiente.jugadores.apellido + "  ");
        if (this.iniciar.revolver.Fuego()) {
            eliminados += iniciar.siguiente.jugadores.nombre + " "
                    + iniciar.siguiente.jugadores.apellido + "  "
                    + "\n";
            System.out.println(iniciar.jugadores.nombre
                    + " Mato a " + iniciar.siguiente.jugadores.nombre + "-");
            iniciar.siguiente = iniciar.siguiente.siguiente;
            numparticipantes--;

        } else {
            System.out.println(iniciar.jugadores.nombre + " Fallo");

        }
        iniciar = iniciar.siguiente; // Se le pasa el turno al otro participante
    }

    public void ImprimirLista() {
        nodo aux = this.iniciar;
        switch (this.numparticipantes) {

            case 1:
                System.out.println("  ");
                System.out.println(" Jugador:  " + aux.jugadores.nombre + "  " + aux.jugadores.apellido + " Gano este juego suicida!!!");
                this.Ganador = aux.jugadores.nombre + " " + aux.jugadores.apellido + "\n";
                break;

            default:
                System.out.println("" + aux.jugadores.nombre + " " + aux.jugadores.apellido);
                while (aux.siguiente != iniciar) {
                    aux = aux.siguiente;
                    System.out.println("" + aux.jugadores.nombre + " " + aux.jugadores.apellido);

                }
                break;
        }
    }

}
