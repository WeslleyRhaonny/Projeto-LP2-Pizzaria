package Server.servidor;

import Server.pedido.NovoPedido;

public class TreatmentProtocol {
    public static double solicitaPedido(String novoPedido) {
        NovoPedido pedido = new NovoPedido(novoPedido);
        boolean confirmacao = pedido.verificaPedido();
        
        if (confirmacao) {
            CaixaPizzaria.atualizaSaldo(pedido.valorTotal());
            System.out.println("Saldo da pizzaria: " + CaixaPizzaria.saldo);
            return pedido.valorTotal();
        } else {
            return -1;
        }
    }
}
