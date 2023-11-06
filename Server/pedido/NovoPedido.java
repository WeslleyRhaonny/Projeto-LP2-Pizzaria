package Server.pedido;

public class NovoPedido {
    Pizza pizza = new Pizza();
    Bebida bebida = new Bebida();
    Pagamento pagamento = new Pagamento();
    static double valorTotal = 0;
    String[] pedido;

    public NovoPedido(String pedido) {
        this.pedido = pedido.split(";");
    }

    public boolean verificaPedido() {
        NovoPedido.valorTotal = 0;
        boolean verificaPizza = pizza.selectSabor(pedido[0], Double.parseDouble(pedido[1]));
        boolean verificaBebida = bebida.selectBebida(pedido[2]);
        boolean verificaPagamento = pagamento.selectPagamento(pedido[3]);
        boolean verificaCartao = true;
        if (pedido[3].equals("Crédito") || pedido[3].equals("Débito")) {
            // Verifica cartão tem que ser inicializada antes para entrar no processamento.
            verificaCartao = pagamento.processaCartao(pedido[4]);
        }

        NovoPedido.valorTotal = Pizza.valor + Bebida.valor;

        if (verificaPizza && verificaBebida && verificaPagamento && verificaCartao) {
            return true;
        } else {
            return false;
        }
    }

    public double valorTotal() {
        return valorTotal;
    }

}
