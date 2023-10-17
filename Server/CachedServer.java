package Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CachedServer {
    public static void main(String[] args) {
        int port = 12345;
        int maxThreads = 10;

        Executor threadPool = Executors.newFixedThreadPool(maxThreads);

        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor TCP iniciado na porta " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Novo cliente conectado: " + clientSocket.getInetAddress());

                // Utilize o pool de threads para lidar com o cliente
                threadPool.execute(new ProtocolServer(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
