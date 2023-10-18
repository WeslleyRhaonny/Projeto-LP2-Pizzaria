package Server.pedido;

import java.util.ArrayList;

public class Pizza {
    ArrayList<String> sabores = new ArrayList<>();
    String sabor;
    static double valor = 0;

    public Pizza(){
        sabores.add("frango");
        sabores.add("queijo");
        sabores.add("calabresa");
    }

    public boolean selectSabor(String sabor){
        if(sabores.contains(sabor)){
            this.sabor = sabor;
            this.valor = setValor(sabor);
            return true;
        }else {
            return false;
        }
    }

    public double setValor(String sabor){
        if(sabor == "frango"){
            return 20;
        }else if(sabor == "queijo"){
            return 22;
        }else{
            return 24;
        }
    }

}
