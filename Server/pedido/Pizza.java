package Server.pedido;

import java.util.ArrayList;

public class Pizza {
    ArrayList<String> sabores = new ArrayList<>();
    String sabor;
    static double valor = 0;

    public Pizza(){
        sabores.add("Frango");
        sabores.add("Mussarela");
        sabores.add("Calabresa");
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
        if (sabor.equals("Frango")){
            return 35;
        } else if(sabor.equals("Mussarela")){
            return 30;
        } else if(sabor.equals("Calabresa")){
            return 36;
        } else {
            return 0;
        }
    }

}
