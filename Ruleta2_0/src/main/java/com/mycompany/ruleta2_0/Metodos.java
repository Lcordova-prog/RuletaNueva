
package com.mycompany.ruleta2_0;

import static com.mycompany.ruleta2_0.MainRuleta.leer;
import static com.mycompany.ruleta2_0.MainRuleta.registroParticipantes;
import java.io.IOException;


public class Metodos {
     public void Comenzarjuego() throws IOException, InterruptedException {
        String ele;
        int a = 0;
        System.out.println("");
        System.out.println("Ingrese Enter para iniciar");
        ele = leer.nextLine();

        FuncioanamientoRuleta C;
        if (registroParticipantes != null) {
            C = new FuncioanamientoRuleta(registroParticipantes);
        } else {
            C = new FuncioanamientoRuleta(LeerArchivos.leerArchivo("C:\\Users\\Pc1\\Desktop\\Proyetos_Java\\Ruleta2_0\\src\\main\\java\\com\\mycompany\\ruleta2_0\\Participantes.in"));
        }
        System.out.println("Los participantes son: ");
        C.ImprimirLista();
        if (ele.equalsIgnoreCase("")) {
 System.out.println("Precione Enter para seguir");
            leer.nextLine();
            while (C.numparticipantes > 1) {
                a++;
                System.out.println("Comieza la Ronda: " + a);
                for (int i = 0; i < C.numparticipantes; i++) {
                    C.ApretarGatillo();
                    try {
                        Thread.sleep(2200);
                    } catch (InterruptedException e) {
                        System.out.println("Error!!");
                    }
                }
                if (C.numparticipantes > 1) {
                    System.out.println("Participantes vivos: " + "\n");
                    C.ImprimirLista();
                    System.out.println("\n");
                }
                System.out.println("Cargando......");
                System.out.println("Cargando....");
                System.out.println("Cargando...");
            }
        } 
         
        C.ImprimirLista();

        LeerArchivos.escribirArchivo("C:\\Users\\Pc1\\Desktop\\Proyetos_Java\\Ruleta2_0\\src\\main\\java\\com\\mycompany\\ruleta2_0\\Derrotados.out", C.eliminados, " Los eliminados " + " son: ");

        LeerArchivos.escribirArchivo("C:\\Users\\Pc1\\Desktop\\Proyetos_Java\\Ruleta2_0\\src\\main\\java\\com\\mycompany\\ruleta2_0\\Ganador.out", C.Ganador, "El Ganador que sobrevivio  " + a + " Rondas " + " Es: ");
    }

    public void ver() throws IOException {
        String jugadores;
        if (registroParticipantes != null) {
            jugadores = registroParticipantes;
        } else {
            jugadores = LeerArchivos.leerArchivo("C:\\Users\\Pc1\\Desktop\\Proyetos_Java\\Ruleta2_0\\src\\main\\java\\com\\mycompany\\ruleta2_0\\Participantes.in");

        }
        System.out.println("°°° Lista de participantes °°°");
        String[] listap = jugadores.split("\n");

        System.out.println(listap[0]);
        for (int i = 1; i < listap.length; i++) {
            System.out.println(listap[i]);
        }
    }

    
}
