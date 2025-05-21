import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        arvore arv = new arvore();

        int opcao;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Contador de Nós");
            System.out.println("2. Pré-Ordem");
            System.out.println("3. Em Ordem");
            System.out.println("4. Pós-Ordem");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

        } while (opcao!=5);


    }
}