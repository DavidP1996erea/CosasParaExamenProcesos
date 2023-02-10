package TCP_Int_String;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args){

        try {
            // 1 - Creación de socket de tipo cliente
            InetAddress direccion = InetAddress.getLocalHost();
            Socket socketCliente = new Socket(direccion, 50000);

            // 2 - Abrir flujos de lectura y escritura
            OutputStream os = socketCliente.getOutputStream();
            InputStream is = socketCliente.getInputStream();

            // 3 - Intercambio de datos con el servidor
            OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
            BufferedWriter bw = new BufferedWriter(osw);

            // Envía los datos al servidor
            bw.write(leeNumero());
            bw.newLine();
            bw.flush();

            // Se recibe la respuesta del servidor
            InputStreamReader isr = new InputStreamReader(is, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            System.out.println("Mensaje recibido por cliente: " + br.readLine());


            // 4 - Cerrar los flujos de lectura y escritura
            bw.close();
            osw.close();
            br.close();
            isr.close();
            is.close();
            os.close();

            // 5 - Cerrar la conexión
            socketCliente.close();

        } catch (UnknownHostException e) {
            System.err.println("ERROR: No se encuentra el host");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("ERROR: Problema con la conexión");
            e.printStackTrace();
        }


    }

    public static int leeNumero() {
        int numero;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Introduzca un número:");
            numero = sc.nextInt();
        } while (numero <= 0);

        sc.close();

        return numero;
    }
}
