package Server.pedido;

import java.util.ArrayList;

public class Pagamento {
    ArrayList<String> formasPagamento = new ArrayList<>();
    String pagamento;

    public Pagamento(){
        formasPagamento.add("Crédito");
        formasPagamento.add("Débito");
        formasPagamento.add("Dinheiro");
    }

    public boolean selectPagamento(String pagamento){
        if(formasPagamento.contains(pagamento)){
            this.pagamento = pagamento;
            return true;
        }else {
            return false;
        }
    }

    public boolean processaCartao(String cartao){
        if(cartao.length() == 16){
            return true;
        }
        else{
            return false;
        }
    }

}
