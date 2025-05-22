import java.util.LinkedList;
import java.util.Queue;

public class arvore {

    no raiz;

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
    
        public int contarnos (no node){
        
            if (node == null) return 0;
            return 1 + contarnos(node.esquerda) + contarnos(node.direita);

        }

    }

    public void buscaPreOrdem(no node) {
        
        if (node != null) {
            
            System.out.println(node.valor + " ");
            buscaPreOrdem(node.esquerda);
            buscaPreOrdem(node.direita);
        }

    }

        public void buscaEmOrdem(no node) {
        
        if (node != null) {
            
            buscaEmOrdem(node.esquerda);
            System.out.println(node.valor + " ");
            buscaEmOrdem(node.direita);
        }
    
    }

    public void buscaPosOrdem(no node) {
        
        if (node != null) {
            
            buscaPosOrdem(node.esquerda);
            buscaPosOrdem(node.direita);
            System.out.println(node.valor + " ");
        }
    
    }

    public void buscaEmNivel () {

        if (raiz == null) return;

        Queue<no> fila = new LinkedList<>();
        fila.add(raiz);

        while (!fila.isEmpty()) {
            no atual = fila.poll();
            System.out.println(atual.valor + " ");

            if (atual.esquerda != null) fila.add(atual.esquerda);
            if (atual.direita != null) fila.add(atual.direita);
        }
    }

}