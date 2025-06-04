public class arvoreAvl {
    private noAvl raiz;

    private int altura(noAvl no) {
        return (no == null) ? 0 : no.altura;
    }

    private int fatorBalanceamento(noAvl no) {
        return (no == null) ? 0 : altura(no.esquerda) - altura(no.direita);
    }

    private noAvl rotacaoDireita(noAvl y) {
        noAvl x = y.esquerda;
        noAvl T2 = x.direita;

        x.direita = y;
        y.esquerda = T2;

        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;
        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;

        return x;
    }

    private noAvl rotacaoEsquerda(noAvl x) {
        noAvl y = x.direita;
        noAvl T2 = y.esquerda;

        y.esquerda = x;
        x.direita = T2;

        x.altura = Math.max(altura(x.esquerda), altura(x.direita)) + 1;
        y.altura = Math.max(altura(y.esquerda), altura(y.direita)) + 1;

        return y;
    }

    private noAvl balancear(noAvl no) {
        int fb = fatorBalanceamento(no);

        if (fb > 1 && fatorBalanceamento(no.esquerda) >= 0) {
            return rotacaoDireita(no);
        }

        if (fb > 1 && fatorBalanceamento(no.esquerda) < 0) {
            no.esquerda = rotacaoEsquerda(no.esquerda);
            return rotacaoDireita(no);
        }

        if (fb < -1 && fatorBalanceamento(no.direita) <= 0) {
            return rotacaoEsquerda(no);
        }

        if (fb < -1 && fatorBalanceamento(no.direita) > 0) {
            no.direita = rotacaoDireita(no.direita);
            return rotacaoEsquerda(no);
        }

        return no;
    }

    public void inserir(String valor) {
        raiz = inserir(raiz, valor);
    }

    private noAvl inserir(noAvl no, String valor) {
        if (no == null)
            return new noAvl(valor);

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = inserir(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = inserir(no.direita, valor);
        else
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }

    public void excluir(String valor) {
        raiz = excluir(raiz, valor);
    }

    private noAvl excluir(noAvl no, String valor) {
        if (no == null)
            return no;

        if (valor.compareTo(no.valor) < 0)
            no.esquerda = excluir(no.esquerda, valor);
        else if (valor.compareTo(no.valor) > 0)
            no.direita = excluir(no.direita, valor);
        else {
            if (no.esquerda == null || no.direita == null) {
                no = (no.esquerda != null) ? no.esquerda : no.direita;
            } else {
                noAvl temp = menorValor(no.direita);
                no.valor = temp.valor;
                no.direita = excluir(no.direita, temp.valor);
            }
        }

        if (no == null)
            return no;

        no.altura = 1 + Math.max(altura(no.esquerda), altura(no.direita));
        return balancear(no);
    }

    private noAvl menorValor(noAvl no) {
        noAvl atual = no;
        while (atual.esquerda != null)
            atual = atual.esquerda;
        return atual;
    }

    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }

    private void preOrdem(noAvl no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerda);
            preOrdem(no.direita);
        }
    }

    public boolean buscar(String valor) {
        return buscar(raiz, valor);
    }

    private boolean buscar(noAvl no, String valor) {
        if (no == null)
            return false;
        if (valor.equals(no.valor))
            return true;
        return valor.compareTo(no.valor) < 0 ? buscar(no.esquerda, valor) : buscar(no.direita, valor);
    }
}
