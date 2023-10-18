package Server;

import java.io.*;
import java.net.Socket;

public class ProtocolServer implements Runnable {

    private Socket s;

    public ProtocolServer(Socket s) {
        this.s = s;
    }

    private String protocol(String msg) {
        String msgTratada;
        return msgTratada = "Resposta para: " + msg;
    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());

            while (!s.isClosed()) {
                if (in.available() > 0) {
                    String fromClient = in.readUTF();
                    if (fromClient.equals("exiit")) {
                        break;
                    }
                    out.writeUTF(protocol(fromClient));
                }
            }
            in.close();
            out.close();
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

