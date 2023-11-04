package Client;

import Server.pedido.Pizza;

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
            int op = -1;
            while (op != 2) {
                Scanner leitor = new Scanner(System.in);
                String pizza = "";
                String bebida = "";
                String tipo_de_pagamento = "";
                String numero_do_cartao = "";
                while(op == -1){
                    System.out.println("1 - Fazer pedido;\n2 - Status do pedido;\n3 - Sair; ");

                        if(leitor.hasNextInt()) {
                            op = leitor.nextInt();
                            leitor.nextLine();
                            if( op < 1 || op > 3){
                                System.out.println("Comando inválido. Digite um valor entre 1 e 3.");
                            }
                        } else {
                            System.out.println("Comando inválido. Digite um valor numerico.");
                            leitor.nextLine();
                    }

                }



                switch (op){
                    case 1:
                        pizza = MenuCliente.selectPizza();
                        bebida = MenuCliente.selectBebida();
                        tipo_de_pagamento = MenuCliente.selectPagamento();
                        if (tipo_de_pagamento == "Débito" || tipo_de_pagamento == "Crédito"){
                            while(true) {
                                try{
                                System.out.println("Digite o número do cartão: ");
                                numero_do_cartao = leitor.nextLine();

                                for(char n : numero_do_cartao.toCharArray()){
                                    Integer.parseInt(String.valueOf(n));

                                }

                                break;

                                }catch (Exception e){
                                    System.out.println("Voce digitou um valor invalido do cartao");
                                }

                            }

                        }



                    case 2:
                        break;
                    case 3:
                        System.out.println("Fechando aplicação.");
                        return;
                }

                op = -1;

                Mensagem m = new Mensagem(pizza, bebida, tipo_de_pagamento, numero_do_cartao);

                out.writeUTF(m.toOneString());
                String fromServer = in.readUTF();
                if (!fromServer.isEmpty()) {
                    System.out.println(fromServer);
                }
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
