package br.com.calculadora.pos.fixa;


public class PilhaDinamica<T> implements Pilha<T> {
    private ListaEncadeada<T> listaEncadeada;
    private int limite;
    private int tamanhoAtual;

    public PilhaDinamica(int limite) {
        this.limite = limite;
        this.listaEncadeada = new ListaEncadeada<T>();
    }

    @Override
    public void push(T info) {
        if (limite == tamanhoAtual) {
            throw new RuntimeException("Capacidade Esgotada na Pilha");
        }
        this.listaEncadeada.inserir(info);
        tamanhoAtual++;
    }

    @Override
    public T pop() {
        T valor = this.peek();
        tamanhoAtual--;
        listaEncadeada.retirar(valor);
        return valor;
    }

    @Override
    public T peek() {
        if (estaVazia()) {
            throw new RuntimeException("Pilha está vazia");
        }
        return listaEncadeada.pegar(listaEncadeada.getTamanho() - 1);
    }

    @Override
    public boolean estaVazia() {
        return (tamanhoAtual == 0);
    }

    @Override
    public void liberar() {
        this.listaEncadeada = new ListaEncadeada<T>();
        this.tamanhoAtual = 0;
    }

    @Override
    public String toString() {
        String str = "topo[";
         for (int i = tamanhoAtual-1; i >= 0; i--) {
                str += listaEncadeada.pegar(i).toString()+", ";
            }
        return str+"]base";
    }

}