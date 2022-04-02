package br.com.calculadora.pos.fixa;

public interface Lista<T> {
	void inserir(T valor);
	String exibir();
	int buscar(T valor);
	boolean estaVazia();
	void retirar(T valor);
	Lista<T> copiar();
	void concatenar(Lista<T> outraLista);
	int getTamanho();
	Lista<T> dividir();
	T pegar(int posicao);
}
