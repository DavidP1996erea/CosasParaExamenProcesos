package LeerEscribirFicheros;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class Escribir {


    public static void insertarEnFichero(String mensaje){
        try {
            String filePath = "C:\\Users\\ruben\\Desktop\\demo.txt";
            FileWriter fw = new FileWriter(filePath, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(mensaje);
            bw.newLine();
            bw.close();
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
