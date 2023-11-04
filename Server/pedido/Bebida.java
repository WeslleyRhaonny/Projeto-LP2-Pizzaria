package Server.pedido;

import java.util.ArrayList;

public class Bebida {
    ArrayList<String> bebidas = new ArrayList<>();
    String bebida;
    static double valor = 0;

    public Bebida(){
        bebidas.add("Refrigerante");
        bebidas.add("Suco");
        bebidas.add("Cerveja");
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
        if(bebida.equals("Suco")){
            return 6;
        }else if(bebida.equals("Refrigerante")){
            return 8;
        }else if(bebida.equals("Cerveja")){
            return 10;
        }else {
            return 0;
        }
    }
}
