package Server.pedido;

import java.util.ArrayList;

public class Pizza {
    ArrayList<String> sabores = new ArrayList<>();
    String sabor;
    static double valor = 0;
    static double multiplier = 1;

    public Pizza(){
        sabores.add("Frango");
        sabores.add("Mussarela");
        sabores.add("Calabresa");
    }

    public void setMultiplier(double multiplier){
        valor = valor * multiplier;
    }

    public boolean selectSabor(String sabor, double multiplicador){
        if(sabores.contains(sabor)){
            this.sabor = sabor;
            Pizza.valor = setValor(sabor) * multiplicador;
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
