package Client;

public class Mensagem {
    private double multiplicador;
    private String pizza;
    private String bebida;
    private String pagamento;
    private String num_cartao;

    public Mensagem(String pizza, double multiplicador, String bebida, String forma_de_pagamento, String num_cartao) {
        this.multiplicador = multiplicador;
        this.pizza = pizza;
        this.bebida = bebida;
        this.pagamento = forma_de_pagamento;
        this.num_cartao = num_cartao;
    }

    public String toOneString() {
        return pizza + ";" + multiplicador + ";" + bebida + ";" + pagamento + ";" + num_cartao;
    }

}
