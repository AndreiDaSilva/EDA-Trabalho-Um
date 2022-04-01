package br.com.calculadora.pos.fixa;

public class PilhaVetor<T> implements Pilha<T> {
    private T info[];
    private int limite;
    private int tamanhoAtual;

    public PilhaVetor(int limite) {
        this.limite = limite;
        this.info = (T[]) new Object[limite];
    }

    public int getLimite() {
        return limite;
    }

    @Override
    public void push(T info) {
        if (limite == tamanhoAtual) {
            throw new RuntimeException("Capacidade Esgotada na Pilha");
        }
        this.info[tamanhoAtual] = info;
        tamanhoAtual++;
    }

    @Override
    public T pop() {
        T valor = this.peek();
        tamanhoAtual--;
        info[tamanhoAtual] = null;
        return valor;
    }

    @Override
    public T peek() {
        if (this.estaVazia()) {
            throw new RuntimeException("Pilha vazia");
        }
        return info[tamanhoAtual-1];
    }

    @Override
    public boolean estaVazia() {
        return (tamanhoAtual == 0);
    }

    @Override
    public void liberar() {
        this.info = (T[]) new Object[this.limite];
        this.tamanhoAtual = 0;
    }

    @Override
    public String toString() {
        String str = "topo[";
         for (int i = tamanhoAtual-1; i >= 0; i--) {
                str += info[i].toString()+", ";
            }
        return str+"]base";
    }
}
