package TCP_Int_String;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {
        int numero;
        String mensaje;

        try {
            // 1 - Creación del socket servidor
            ServerSocket socketServidor = new ServerSocket(50000);

            while (true) {
                // 2 - Espera y acepta conexiones
                Socket socketCliente = socketServidor.accept();

                // 3 - Flujos de entrada y salida
                InputStream is = socketCliente.getInputStream();
                OutputStream os = socketCliente.getOutputStream();

                // 4 - Intercambiar datos con el cliente
                InputStreamReader isr = new InputStreamReader(is, "UTF-8");
                BufferedReader br = new BufferedReader(isr);

                // Se lee la respuesta del cliente
                numero = br.read();
                mensaje = esPrimo(numero);

               // Envía los datos al cliente
                OutputStreamWriter osw = new OutputStreamWriter(os, "UTF-8");
                BufferedWriter bw = new BufferedWriter(osw);

                bw.write(mensaje);
                bw.newLine();
                bw.flush();

                // 5 - Cerrar flujos de lectura y escritura

                br.close();
                isr.close();
                is.close();
                bw.close();
                osw.close();
                os.close();

                socketCliente.close();
            }
            // 6 - Cerrar la conexión
//			System.out.println("(Servidor): Cierre de la conexión...");
//			socketCliente.close();
//			socketServidor.close();

        } catch (IOException e) {
            System.err.println("ERROR: Error al crear el socket en el puerto 50000");
            e.printStackTrace();
        }
    }

    public static String esPrimo(int num) {
        String resul = "Es primo";
        boolean enc = false;

        if (num <= 1) {
            resul = "No es primo";
        }
        for (int i = 2; i <= num/2 && !enc; i++) {
            if (num % i == 0) {
                resul = "No es primo";
                enc = true;
            }
        }
        return resul;
    }

}
