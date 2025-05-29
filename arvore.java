import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class arvore {

    public no raiz;

    public arvore() {
        no noA = new no("A");
        no noB = new no("B");
        no noC = new no("C");
        no noD = new no("D");
        no noE = new no("E");
        no noF = new no("F");

        noA.esquerda = noB;
        noA.direita = noC;

        noB.esquerda = noD;
        noB.direita = noE;

        noC.direita = noF;

        raiz = noA;
    }

    public class contadornos {
        public int contarnos(no node) {
            if (node == null) return 0;
            return 1 + contarnos(node.esquerda) + contarnos(node.direita);
        }
    }

    // -> PRÉ-ORDEM

    public void buscaPreOrdemRecursiva(no node) {
        if (node != null) {
            System.out.println(node.valor);
            buscaPreOrdemRecursiva(node.esquerda);
            buscaPreOrdemRecursiva(node.direita);
        }
    }

    public void buscaPreOrdemIterativa() {
        if (raiz == null) return;

        Stack<no> pilha = new Stack<>();
        pilha.push(raiz);

        while (!pilha.isEmpty()) {
            no atual = pilha.pop();
            System.out.println(atual.valor);

            if (atual.direita != null) pilha.push(atual.direita);
            if (atual.esquerda != null) pilha.push(atual.esquerda);
        }
    }

    // -> EM ORDEM

    public void buscaEmOrdemRecursiva(no node) {
        if (node != null) {
            buscaEmOrdemRecursiva(node.esquerda);
            System.out.println(node.valor);
            buscaEmOrdemRecursiva(node.direita);
        }
    }

    public void buscaEmOrdemIterativa() {
        Stack<no> pilha = new Stack<>();
        no atual = raiz;

        while (atual != null || !pilha.isEmpty()) {
            while (atual != null) {
                pilha.push(atual);
                atual = atual.esquerda;
            }

            atual = pilha.pop();
            System.out.println(atual.valor);
            atual = atual.direita;
        }
    }

    // -> PÓS-ORDEM

    public void buscaPosOrdemRecursiva(no node) {
        if (node != null) {
            buscaPosOrdemRecursiva(node.esquerda);
            buscaPosOrdemRecursiva(node.direita);
            System.out.println(node.valor);
        }
    }

    public void buscaPosOrdemIterativa() {
        if (raiz == null) return;

        Stack<no> pilha1 = new Stack<>();
        Stack<no> pilha2 = new Stack<>();

        pilha1.push(raiz);

        while (!pilha1.isEmpty()) {
            no atual = pilha1.pop();
            pilha2.push(atual);

            if (atual.esquerda != null) pilha1.push(atual.esquerda);
            if (atual.direita != null) pilha1.push(atual.direita);
        }

        while (!pilha2.isEmpty()) {
            System.out.println(pilha2.pop().valor);
        }
    }

    // -> EM NÍVEL

    public void buscaEmNivelIterativa() {
        if (raiz == null) return;

        Queue<no> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            no atual = fila.poll();
            System.out.println(atual.valor);

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }

    public void buscaEmNivelRecursiva() {
        int altura = altura(raiz);
        for (int i = 1; i <= altura; i++) {
            imprimeNivel(raiz, i);
        }
    }

    private int altura(no node) {
        if (node == null) return 0;
        return 1 + Math.max(altura(node.esquerda), altura(node.direita));
    }

    private void imprimeNivel(no node, int nivel) {
        if (node == null) return;

        if (nivel == 1) {
            System.out.println(node.valor);
        } else {
            imprimeNivel(node.esquerda, nivel - 1);
            imprimeNivel(node.direita, nivel - 1);
        }
    }

// -> CONTAR NÓS FOLHAS

public int contarNosFolhasRecursivo(no node) {
    if (node == null) return 0;
    if (node.esquerda == null && node.direita == null) return 1;
    return contarNosFolhasRecursivo(node.esquerda) + contarNosFolhasRecursivo(node.direita);
}

public int contarNosFolhasIterativo() {
    if (raiz == null) return 0;

    int contador = 0;
    Stack<no> pilha = new Stack<>();
    pilha.push(raiz);

    while (!pilha.isEmpty()) {
        no atual = pilha.pop();

        if (atual.esquerda == null && atual.direita == null) {
            contador++;
        }

        if (atual.direita != null) pilha.push(atual.direita);
        if (atual.esquerda != null) pilha.push(atual.esquerda);
    }

    return contador;
}


    private int calcularAltura(no node) {
        if (node == null) return 0;
        return 1 + Math.max(calcularAltura(node.esquerda), calcularAltura(node.direita));
    }

    private void atualizarAlturaEFator(no node) {
        if (node == null) return;

        atualizarAlturaEFator(node.esquerda);
        atualizarAlturaEFator(node.direita);

        int alturaEsquerda = calcularAltura(node.esquerda);
        int alturaDireita = calcularAltura(node.direita);
        node.altura = 1 + Math.max(alturaEsquerda, alturaDireita);
        node.fatorBalanceamento = alturaEsquerda - alturaDireita;
    }
    
}
