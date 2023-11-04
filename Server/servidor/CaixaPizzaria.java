package Server.servidor;

public class CaixaPizzaria {
    public static double saldo = 0;

    public static synchronized void atualizaSaldo (double valor){
        saldo += valor;
    }
}
