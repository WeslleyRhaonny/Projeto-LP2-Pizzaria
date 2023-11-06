package Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
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
            Scanner leitor = new Scanner(System.in);

            int op = -1;

            while (op != 3) {
                op = -1;

                double multiplicador = 1;
                String pizza = "";
                String bebida = "";
                String tipo_de_pagamento = "";
                String numero_do_cartao = "";

                while (op == -1) {
                    System.out.println("1 - Fazer pedido;\n2 - Status do pedido;\n3 - Sair; ");

                    if (leitor.hasNextInt()) {
                        op = leitor.nextInt();
                        leitor.nextLine();

                        if (op < 1 || op > 3) {
                            System.out.println("Comando inválido. Digite um valor entre 1 e 3.");
                        }
                    } else {
                        System.out.println("Comando inválido. Digite um valor numerico.");
                        leitor.nextLine();
                    }
                }

                switch (op) {
                    case 1:
                        multiplicador = MenuCliente.selectMultiplicador();
                        pizza = MenuCliente.selectPizza();
                        bebida = MenuCliente.selectBebida();
                        tipo_de_pagamento = MenuCliente.selectPagamento();

                        if (tipo_de_pagamento == "Débito" || tipo_de_pagamento == "Crédito") {
                            while (true) {
                                try {
                                    System.out.println("Digite o número do cartão: ");
                                    numero_do_cartao = leitor.nextLine();

                                    new BigInteger(numero_do_cartao);
                                    break;
                                } catch (Exception e) {
                                    System.out.println("Voce digitou um valor invalido do cartao");
                                }
                            }
                        }

                        break;
                    case 2:
                        out.writeUTF("getstatus");

                        String status = in.readUTF();

                        if (status.equals("0")) {
                            System.out.println("Seu pedido está atualmente em produção. Aguarde mais um momento.");
                        } else if (status.equals("1")) {
                            System.out.println("Seu pedido está a caminho! Aguarde um instante.");
                        } else {
                            System.out.println("Você não parece ter um pedido em produção no momento.");
                        }

                        continue;
                    case 3:
                        System.out.println("Fechando aplicação.");
                        return;
                }

                Mensagem m = new Mensagem(pizza, multiplicador, bebida, tipo_de_pagamento, numero_do_cartao);
                out.writeUTF(m.toOneString());

                String fromServer = in.readUTF();

                if (!fromServer.isEmpty()) {
                    if (fromServer.equals("wait")) {
                        System.out.println(
                                "Você já tem um pedido em produção. Espere ele ser entregue para pedir novamente.");
                    } else {
                        System.out.println(fromServer);
                    }
                }
            }

            leitor.close();
            socket.close();
        } catch (

        IOException e) {
            e.printStackTrace();
        }
    }
}
