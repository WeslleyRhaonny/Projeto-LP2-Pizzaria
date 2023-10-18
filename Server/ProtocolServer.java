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
                    if (fromClient.equals("exit")) {
                        break;
                    }

                    ProtocoloTratamento prot = new ProtocoloTratamento();

                    boolean confirmacao = prot.tratamentoPedido(fromClient);
                    if(confirmacao == true){
                        out.writeUTF("Pedido Confirmado");
                    }
                    else{
                        out.writeUTF("Erro No pedido, faça novamente");
                    }
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

