import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        arvore arv = new arvore();
        arvore.contadornos contador = arv.new contadornos();

        int opcao;
        do {
            System.out.println("\n----- MENU -----");
            System.out.println("1. Contador de Nós");
            System.out.println("2. Pré-Ordem");
            System.out.println("3. Em Ordem");
            System.out.println("4. Pós-Ordem");
            System.out.println("5. Em Nível");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    int totalNos = contador.contarnos(arv.raiz);
                    System.out.println("Total de nós: " + totalNos);
                    break;

                case 2:
                    System.out.println("1. Versão Recursiva");
                    System.out.println("2. Versão Iterativa");
                    System.out.print("Escolha o tipo de busca Pré-Ordem: ");
                    int preTipo = scanner.nextInt();

                    if (preTipo == 1) {
                        System.out.println("Busca Pré-Ordem (Recursiva):");
                        arv.buscaPreOrdemRecursiva(arv.raiz);
                    } else if (preTipo == 2) {
                        System.out.println("Busca Pré-Ordem (Iterativa):");
                        arv.buscaPreOrdemIterativa();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 3:
                    System.out.println("1. Versão Recursiva");
                    System.out.println("2. Versão Iterativa");
                    System.out.print("Escolha o tipo de busca Em Ordem: ");
                    int emTipo = scanner.nextInt();

                    if (emTipo == 1) {
                        System.out.println("Busca Em Ordem (Recursiva):");
                        arv.buscaEmOrdemRecursiva(arv.raiz);
                    } else if (emTipo == 2) {
                        System.out.println("Busca Em Ordem (Iterativa):");
                        arv.buscaEmOrdemIterativa();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 4:
                    System.out.println("1. Versão Recursiva");
                    System.out.println("2. Versão Iterativa");
                    System.out.print("Escolha o tipo de busca Pós-Ordem: ");
                    int posTipo = scanner.nextInt();

                    if (posTipo == 1) {
                        System.out.println("Busca Pós-Ordem (Recursiva):");
                        arv.buscaPosOrdemRecursiva(arv.raiz);
                    } else if (posTipo == 2) {
                        System.out.println("Busca Pós-Ordem (Iterativa):");
                        arv.buscaPosOrdemIterativa();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 5:
                    System.out.println("1. Versão Recursiva");
                    System.out.println("2. Versão Iterativa");
                    System.out.print("Escolha o tipo de busca Em Nível: ");
                    int nivelTipo = scanner.nextInt();

                    if (nivelTipo == 1) {
                        System.out.println("Busca Em Nível (Recursiva):");
                        arv.buscaEmNivelRecursiva();
                    } else if (nivelTipo == 2) {
                        System.out.println("Busca Em Nível (Iterativa):");
                        arv.buscaEmNivelIterativa();
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;

                case 6:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);

        scanner.close();
    }
}
