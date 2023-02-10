package LeerEscribirFicheros;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Leer {
    public static String leerFichero(String direccion) {

        BufferedReader br = null;
        String[] contenido;
        String ip = "";

        try {

            br = new BufferedReader(new FileReader("C:\\Users\\david\\IdeaProjects\\UDPHilos\\src\\Ejercicio2TCP\\DNS"));
            Scanner sc = new Scanner(br);

            while (sc.hasNext()) {
                contenido = sc.nextLine().split(":");
                if (contenido[0].contains(direccion)) {
                    ip = contenido[1];
                }
                if (ip.equals("")) {
                    ip = "Esa direccion no existe";
                }
            }


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return ip;
    }





}
