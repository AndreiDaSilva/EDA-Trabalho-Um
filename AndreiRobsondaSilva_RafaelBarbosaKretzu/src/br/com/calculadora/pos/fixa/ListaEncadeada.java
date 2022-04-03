package br.com.calculadora.pos.fixa;

public class ListaEncadeada<T> implements Lista<T> {
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	private int qtdElementos;

	@Override
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>();
		novo.setInfo(valor);
		if (this.estaVazia()) {
			primeiro = novo;
		} else {
			ultimo.setProx(novo);
		}
		ultimo = novo;
		qtdElementos++;
	}

	@Override
	public String exibir() {
		String resultado = "[";
		NoLista<T> p = primeiro;
		while (p != null) {
			resultado += p.getInfo() + ", ";
			p = p.getProx();
		}
		return resultado + "]";
	}

	@Override
	public int buscar(T valor) {
		int indice = 0;
		NoLista<T> p = primeiro;
		while (p != null) {
			if (p.getInfo().equals(valor)) {
				return indice;
			}
			p = p.getProx();
			indice++;
		}
		return -1;
	}

	@Override
	public boolean estaVazia() {
		return primeiro == null;
	}

	@Override
	public void retirar(T valor) {
		NoLista<T> anterior = null;
		NoLista<T> p = primeiro;
		if (this.estaVazia()) {
			throw new RuntimeException("Quantidade de elementos é igual a ZERO(0)");
		}
		while (p != null && !p.getInfo().equals(valor)) {
			anterior = p;
			p = p.getProx();
		}
		if (p != null) { 
			if (anterior == null) {
				primeiro = p.getProx();
			} else {
				anterior.setProx(p.getProx());
			}
			if (ultimo == p) {
				ultimo = anterior;
			}
			qtdElementos--;
		}

	}

	@Override
	public Lista<T> copiar() {
		Lista<T> listaCopia = new ListaEncadeada<>();
		NoLista<T> p = primeiro;
		while (p != null) {
			T valor = p.getInfo();
			listaCopia.inserir(valor);
			p = p.getProx();
		}
		return listaCopia;
	}

	@Override
	public void concatenar(Lista<T> outra) {
		for (int i = 0; i < outra.getTamanho(); i++) {
			inserir(outra.pegar(i));
		}
	}

	@Override
	public int getTamanho() {
		return this.qtdElementos;
	}

	public Lista<T> dividir() {  
		int qtd = getTamanho() / 2;
		ListaEncadeada<T> novaLista = new ListaEncadeada<>();
		NoLista<T> p = primeiro;
		int contador = 0;

		while (p != null) {
			++contador;
			if (contador > qtd)
				novaLista.inserir(p.getInfo());

			if (contador == qtd) {
				ultimo = p;
			}

			p = p.getProx();
		}
		ultimo.setProx(null);
		qtdElementos = qtd;
		return novaLista;
	}

	@Override
	public T pegar(int posicao) {
		if (posicao <= -1 || posicao >= this.qtdElementos) {
			throw new IndexOutOfBoundsException("Index:" + posicao + " fora dos limites.");
		}
		NoLista<T> noAtual = this.primeiro;
		NoLista<T> noEncontrado = null;
		int posicaoAtual = 0;
		do {
			if (posicaoAtual == posicao) {
				noEncontrado = noAtual;
			}
			noAtual = noAtual.getProx();
			posicaoAtual++;
		} while (noEncontrado == null);
		return noEncontrado.getInfo();
	}
	
	public T retirarUltimo() {
		NoLista<T> anteriorUltimo = this.primeiro;
		NoLista<T> ultimoNo = this.ultimo;
		NoLista<T> atual = this.primeiro;
		if (this.estaVazia()) {
			throw new RuntimeException("Quantidade de elementos é igual a ZERO(0)");
		}
		while (!atual.equals(ultimoNo)) {
			anteriorUltimo = atual;
			atual = atual.getProx();
		}
		this.ultimo = anteriorUltimo;
		this.ultimo.setProx(null);
		qtdElementos--;
		return ultimoNo.getInfo();
	}

}
