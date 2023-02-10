package TCP_Int;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) {

        try {
            // 1 - Crear socket de tipo servidor y le indicamos el puerto
            ServerSocket servidor = new ServerSocket(49200);

            // 2 - Queda a la espera de peticiones y las acepta cuando las recibe
            System.out.println("Servidor se encuentra a la escucha...");
            while(true) {
                Socket peticion = servidor.accept();

                // 3 - Abrir flujos de lectura y escritura de datos
                InputStream is = peticion.getInputStream();
                OutputStream os = peticion.getOutputStream();

                // 4 - Intercambiar datos con el cliente
                // Leer mensaje enviado por el cliente e imprimirlo por consola
                int numero = is.read();
                System.out.println("Mensaje enviado por el cliente: " + numero);

                // Enviarle mensaje al cliente
                System.out.println("Servidor envía al cliente el doble");
                int doble = numero*2;
                OutputStreamWriter osw = new OutputStreamWriter(os);
                BufferedWriter bw = new BufferedWriter(osw);
                // Se pasa un int
                os.write(doble);
               // Se pasa un String         bw.write(doble+"");
                bw.newLine();
                bw.flush();

                // 5 - Cerrar flujos de lectura y escritura
                bw.close();
                osw.close();
                is.close();
                os.close();
            }
            // 6 - Cerra la conexión
//			System.out.println("Cierre de conexiones");
//			peticion.close();
//			servidor.close();

        } catch (IOException e) {
            System.err.println("Ha habido algún error en la creación del Socket Servidor");
            e.printStackTrace();
        }
    }
}
