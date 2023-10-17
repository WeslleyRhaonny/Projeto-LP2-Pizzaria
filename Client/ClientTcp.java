package Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientTcp {
    public static void main(String[] args) {
        String serverAddress = "localhost"; // Endereço do servidor
        int serverPort = 12345; // Porta do servidor

        try {
            Socket socket = new Socket(serverAddress, serverPort);

            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.print("Digite uma mensagem para o servidor (ou 'exit' para sair): ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("exit")) {
                    break; // Sai do loop se "exit" for digitado
                }

                out.writeUTF(message);

                String fromServer = in.readUTF();
                if(!fromServer.isEmpty()){
                    System.out.println(fromServer);
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

