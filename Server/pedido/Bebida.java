package Server.pedido;

import java.util.ArrayList;

public class Bebida {
    ArrayList<String> bebidas = new ArrayList<>();
    String bebida;
    static double valor = 0;

    public Bebida(){
        bebidas.add("refrigerante");
        bebidas.add("suco");
        bebidas.add("cerveja");
    }

    public boolean selectBebida(String bebida){
        if(bebidas.contains(bebida)){
            this.bebida = bebida;
            this.valor = setValor(bebida);
            return true;
        }else {
            return false;
        }
    }

    public double setValor(String bebida){
        if(bebida == "refrigerante"){
            return 6;
        }else if(bebida == "suco"){
            return 8;
        }else{
            return 10;
        }
    }
}
