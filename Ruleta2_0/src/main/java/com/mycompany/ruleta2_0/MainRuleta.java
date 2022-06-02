package com.mycompany.ruleta2_0;

import java.io.IOException;
import java.util.Scanner;

public class MainRuleta {

    LeerArchivos ar;
    static String registroParticipantes;
    static Scanner leer = new Scanner(System.in);
    
    public static void main(String[] args) throws IOException, InterruptedException {
        Metodos metodos = new Metodos();
        String boton = "";
        do {
            System.out.println("  _____________ |Menu Ruleta Rusa| _____________ \n"
                    + " |         ____Te atreves a jugar?____         | \n"
                    + " |\t 1.----->Ver participantes<------1." + "    | \n"
                    + " |\t 2.----->Iniciar Juego<----------2." + "    | \n"
                    + " |\t 0.----->Salir del Juego<--------0." + "    | \n"
                    + "  ___________________________________________");
            boton = leer.nextLine();
            switch (boton) {
                case "1":
                    metodos.ver();
                    break;

                case "2":
                  metodos.Comenzarjuego();
                    break;
            }
        } while (!boton.equals("0"));

    }

   
}
