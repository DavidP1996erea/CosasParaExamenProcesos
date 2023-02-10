package UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Cliente {
    public static void main(String[] args) {


        DatagramSocket socket = null;
        int puertoServidor = 49201;
        String nombreServidor = "localhost";
        try {
            // 1 - Obtención de la dirección del servidor usando el métod getByName de
            // InetAddress

            InetAddress direccionServidor = InetAddress.getByName(nombreServidor);

            // 2 - Creación del socket UDP

            socket = new DatagramSocket();

            // 3 - Generación del datagrama

            byte[] bufferSalida = new String("Mensaje enviado desde el cliente").getBytes();
            DatagramPacket paqueteSalida = new DatagramPacket(bufferSalida, bufferSalida.length, direccionServidor,
                    puertoServidor);

            // 4 - Envío del datagrama a través de send

            socket.send(paqueteSalida);

            // 5 - Recepción de la respuesta
            //Número de letras del mensaje
            byte[] bufferEntrada = new byte[33];
            DatagramPacket paqueteEntrada = new DatagramPacket(bufferEntrada, bufferEntrada.length, direccionServidor,
                    puertoServidor);
            socket.receive(paqueteEntrada);
            System.out.println("Mensaje recibido: " + new String(bufferEntrada).trim());

            // 6 - Cierre del socket

            socket.close();


        } catch (SocketException e) {
            System.err.println("Error al conectar con el servidor.");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("No se ha podido enviar o recibir el paquete");
            e.printStackTrace();
        }
    }
}
