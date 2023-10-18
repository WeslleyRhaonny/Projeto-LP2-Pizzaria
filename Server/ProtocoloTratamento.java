package Server;

import java.util.ArrayList;

public class ProtocoloTratamento {
    public double saldo = 0;
    public Pedido pedido;

    public static String[] separaString(String pedido){
        String[] dadosArray = pedido.split(";");

        return dadosArray;
    }
    public static Boolean verificaSabor(String sabor){
        ArrayList<String> sabores = new ArrayList<>();
        sabores.add("frango");
        sabores.add("queijo");
        sabores.add("calabresa");
        sabores.add("portuguesa");
        sabores.add("sertaneja");

        if(sabores.contains(sabor)){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean verificaCartao(String formaPagamento, String numeroCartao){
        if(formaPagamento == "especie"){
            return true;
        }
        else if(formaPagamento == "credito" || formaPagamento == "Debito"){
            if(numeroCartao.length() == 16){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    };
    public Boolean tratamentoPedido(String pedido){
        Pedido pedidoCliente = new Pedido();
        String[] pedidoTratado = separaString(pedido);
        pedidoCliente.sabor = pedidoTratado[0];
        pedidoCliente.endereco = pedidoTratado[1];
        pedidoCliente.valor = Double.parseDouble(pedidoTratado[2]);
        pedidoCliente.formaDePagamento = pedidoTratado[3];
        pedidoCliente.numeroCartao = pedidoTratado[4];
        if(pedidoCliente.confirmaRefri == "s" || pedidoCliente.confirmaRefri == "S"){
            pedidoCliente.refri = pedidoTratado[5];
        }

        boolean confirmacao1 = verificaSabor(pedidoCliente.sabor);
        boolean confirmacao2 = verificaCartao(pedidoTratado[3], pedidoTratado[4]);

        if(confirmacao1 == true && confirmacao2 == true){
            CaixaPizzaria.saldo = CaixaPizzaria.saldo + pedidoCliente.valor;
            return true;
        }
        else{
            return false;
        }
    }
}
