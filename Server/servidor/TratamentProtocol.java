package Server.servidor;

import Server.pedido.NovoPedido;

public class TratamentProtocol {

    public static String solicitaPedido(String novoPedido){
        NovoPedido pedido = new NovoPedido(novoPedido);
        boolean confirmacao = pedido.verificaPedido();
        //System.out.println("Valor do pedido: " + pedido.valorTotal());
        if(confirmacao){
            CaixaPizzaria.atualizaSaldo(pedido.valorTotal());
            System.out.println("Saldo da pizzaria: " + CaixaPizzaria.saldo);
            return "Pedido confirmado! Valor total: " + pedido.valorTotal();
        }else{
            return "Pedido negado. Houve erro na inserção de dados";
        }
    }

}
