package Client;

import java.util.Scanner;

public class MenuCliente {
    private static Scanner leitor;

    public MenuCliente() {
        leitor = new Scanner(System.in);
    }

    public static String selectPizza() {
        leitor = new Scanner(System.in);
        int sabor = -1;

        while (sabor == -1) {
            System.out.println("1. Pizza Frango R$ 35,00");
            System.out.println("2. Pizza Mussarela R$ 30,00");
            System.out.println("3. Pizza Calabresa R$ 36,00");

            if (leitor.hasNextInt()) {
                sabor = leitor.nextInt();
                leitor.nextLine();

                if (sabor < 1 || sabor > 3) {
                    System.out.println("Pedido inválido. Digite um valor entre 1 e 3.");
                    sabor = -1;
                }
            } else {
                System.out.println("Pedido inválido. Digite um valor entre 1 e 3.");
                leitor.nextLine();
            }
        }

        switch (sabor) {
            case 1:
                return "Frango";
            case 2:
                return "Mussarela";
            case 3:
                return "Calabresa";
        }

        return "qualquer";
    }

    public static double selectMultiplicador() {
        int multiplicador = -1;
        leitor = new Scanner(System.in);

        while (multiplicador == -1) {
            System.out.println("\n1. Pequena (80% do valor)");
            System.out.println("2. Média (100% do valor)");
            System.out.println("3. Grande (135% do valor)");
            System.out.println("4. Família (175% do valor)");

            if (leitor.hasNextInt()) {
                multiplicador = leitor.nextInt();
                leitor.nextLine();

                if (multiplicador < 1 || multiplicador > 4) {
                    System.out.println("Pedido inválido. Digite um valor entre 1 e 4.");
                    multiplicador = -1;
                }
            } else {
                System.out.println("Pedido inválido. Digite um valor entre 1 e 4.");
                leitor.nextLine();
            }
        }

        switch (multiplicador) {
            case 1:
                return 0.8;
            case 2:
                return 1;
            case 3:
                return 1.35;
            default:
                return 1.75;
        }
    }

    public static String selectBebida() {
        int bebida = -1;
        leitor = new Scanner(System.in);

        while (bebida == -1) {
            System.out.println("\n1. Suco R$ 6,00");
            System.out.println("2. Refrigerante R$ 8,00");
            System.out.println("3. Cerveja R$ 10,00");
            System.out.println("4. Nenhuma bebida.");

            if (leitor.hasNextInt()) {
                bebida = leitor.nextInt();
                leitor.nextLine();

                if (bebida < 1 || bebida > 4) {
                    System.out.println("Pedido inválido. Digite um valor entre 1 e 4.");
                    bebida = -1;
                }
            } else {
                System.out.println("Pedido inválido. Digite um valor entre 1 e 4.");
                leitor.nextLine();
            }
        }

        switch (bebida) {
            case 1:
                return "Suco";
            case 2:
                return "Refrigerante";
            case 3:
                return "Cerveja";
            default:
                return "";
        }
    }

    public static String selectPagamento() {
        leitor = new Scanner(System.in);
        int metodo = -1;

        while (metodo == -1) {
            System.out.println("1. Dinheiro");
            System.out.println("2. Crédito");
            System.out.println("3. Débito");

            if (leitor.hasNextInt()) {
                metodo = leitor.nextInt();
                leitor.nextLine();

                if (metodo < 1 || metodo > 3) {
                    System.out.println("Pedido inválido. Digite um valor entre 1 e 3.");
                    metodo = -1;
                }
            } else {
                System.out.println("Pedido inválido. Digite um valor entre 1 e 3.");
                leitor.nextLine();
            }
        }

        switch (metodo) {
            case 1:
                return "Dinheiro";
            case 2:
                return "Débito";
            case 3:
                return "Crédito";
            default:
                return "";
        }

    }
}
