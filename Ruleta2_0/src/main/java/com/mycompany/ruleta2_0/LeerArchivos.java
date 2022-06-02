package com.mycompany.ruleta2_0;

import java.io.*;

class LeerArchivos {

    static String leerArchivo(String direccion) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(direccion));

        String fila;
        fila = br.readLine();
        String d = fila;
        while ((fila = br.readLine()) != null) {
            d += "\n" + fila;
        }
        return d;

    }

    static void escribirArchivo(String dire, String msg, String Da) throws IOException {
        FileWriter archi = new FileWriter(dire, true);
        try (PrintWriter pw = new PrintWriter(archi)) {
            pw.println(Da);
            pw.println(msg);
            pw.close(); //Cerrar el archivo.
        }

    }

}
