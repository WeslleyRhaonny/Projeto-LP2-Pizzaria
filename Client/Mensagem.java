package Client;

public class Mensagem {
    private String pizza;
    private String bebida;
    private String pagamento;
    private String num_cartao;

    public Mensagem(String pizza, String bebida, String forma_de_pagamento, String num_cartao) {
        this.pizza = pizza;
        this.bebida = bebida;
        this.pagamento = forma_de_pagamento;
        this.num_cartao = num_cartao;

    }

    public String toOneString() {
        return pizza + ";" + bebida + ";" + pagamento + ";" + num_cartao;
    }

}
