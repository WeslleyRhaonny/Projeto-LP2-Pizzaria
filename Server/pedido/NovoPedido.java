package Server.pedido;

import Server.pedido.Bebida;
import Server.pedido.Pizza;

public class NovoPedido {
    Pizza pizza = new Pizza();
    Bebida bebida = new Bebida();
    Pagamento pagamento = new Pagamento();
    static double valorTotal = 0;
    String[] pedido;
    public NovoPedido(String pedido){
        this.pedido = pedido.split(";");
    }

    public boolean verificaPedido(){
        this.valorTotal= 0;
        boolean verificaPizza = pizza.selectSabor(pedido[0]);
        boolean verificaBebida = bebida.selectBebida(pedido[1]);
        boolean verificaPagamento = pagamento.selectPagamento(pedido[2]);
        boolean verificaCartao = true;
        if(pedido[2].equals("credito") || pedido[2].equals("debito")){
            // Verifica cartão tem que ser inicializada antes para entrar no processamento.
            verificaCartao = pagamento.processaCartao(pedido[3]);
        }

        this.valorTotal = pizza.valor + bebida.valor;

        if(verificaPizza && verificaBebida && verificaPagamento && verificaCartao){
            return true;
        }else{
            return false;
        }
    }

    public double valorTotal(){
        return valorTotal;
    }


}
