public class arvore {

    no raiz;

    public arvore() {
        // Criando os nós com os respectivos valores
        no noA = new no("A");
        no noB = new no("B");
        no noC = new no("C");
        no noD = new no("D");
        no noE = new no("E");
        no noF = new no("F");

        // Montando a árvore conforme a imagem
        noA.esquerda = noB;
        noA.direita = noC;

        noB.esquerda = noD;
        noB.direita = noE;

        noC.direita = noF;

        raiz = noA; // Define a raiz da árvore
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

}