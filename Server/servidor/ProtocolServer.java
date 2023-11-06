package Server.servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
            String orderDate = "";

            while (!s.isClosed()) {
                if (in.available() > 0) {
                    String fromClient = in.readUTF();

                    if (fromClient.equals("getstatus")) {
                        if (orderDate.equals("")) {
                            out.writeUTF("-1");
                        } else {
                            long orderDateLong = Long.parseLong(orderDate);
                            long now = System.currentTimeMillis();
                            long diff = now - orderDateLong;
                            long diffMinutes = diff / (60 * 1000) % 60;

                            if (diffMinutes < 1) {
                                out.writeUTF("0");
                            } else if (diffMinutes >= 1 && diffMinutes < 2) {
                                out.writeUTF("1");
                            } else {
                                out.writeUTF("-1");
                                orderDate = "";
                            }
                        }

                        System.out.println("Status do pedido enviado para o cliente.");
                        continue;
                    }

                    if (fromClient.equals("exit")) {
                        break;
                    }

                    if (!orderDate.equals("")) {
                        long orderDateLong = Long.parseLong(orderDate);
                        long now = System.currentTimeMillis();
                        long diff = now - orderDateLong;
                        long diffMinutes = diff / (60 * 1000) % 60;

                        if (diffMinutes < 2) {
                            out.writeUTF("wait");
                            continue;
                        } else {
                            orderDate = "";
                        }
                    }

                    double retorno = TreatmentProtocol.solicitaPedido(fromClient);
                    String retornoString;

                    if (retorno >= 0) {
                        orderDate = String.valueOf(System.currentTimeMillis());
                        retornoString = "Pedido confirmado! Valor total: " + retorno;
                    } else {
                        retornoString = "Pedido negado. Houve erro na inserção de dados";
                    }

                    out.writeUTF(retornoString);
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
