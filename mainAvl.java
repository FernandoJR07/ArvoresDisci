import java.util.Scanner;

public class mainAvl {
    public static void main(String[] args) {
        arvoreAvl arvore = new arvoreAvl();
        Scanner scanner = new Scanner(System.in);
        int opcao;
        String valor;

        arvore.inserir("A");
        arvore.inserir("B");
        arvore.inserir("C");
        arvore.inserir("D");
        arvore.inserir("E");
        arvore.inserir("F");

        do {
            System.out.println("\n--- MENU ÁRVORE AVL ---");
            System.out.println("1. Inserir");
            System.out.println("2. Excluir");
            System.out.println("3. Buscar (PreOrdem)");
            System.out.println("4. Verificar Existência");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a inserir: ");
                    valor = scanner.nextLine().toUpperCase();
                    arvore.inserir(valor);
                    break;
                case 2:
                    System.out.print("Digite o valor a excluir: ");
                    valor = scanner.nextLine().toUpperCase();
                    arvore.excluir(valor);
                    break;
                case 3:
                    System.out.print("Árvore em PreOrdem: ");
                    arvore.preOrdem();
                    break;
                case 4:
                    System.out.print("Digite o valor a buscar: ");
                    valor = scanner.nextLine().toUpperCase();
                    System.out.println(arvore.buscar(valor) ? "Valor encontrado." : "Valor não encontrado.");
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
