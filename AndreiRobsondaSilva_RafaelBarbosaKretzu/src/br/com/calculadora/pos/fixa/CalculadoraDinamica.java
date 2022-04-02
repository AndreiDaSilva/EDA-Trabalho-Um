package br.com.calculadora.pos.fixa;

public class CalculadoraDinamica implements Calculadora {
	private Pilha<Float> operandos = new PilhaDinamica<>(100);
	
	@Override
	public float dividir() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float somar() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float subtrair() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float multiplicar() {
		// TODO Auto-generated method stub
		return 0;
	} 

	private void adicionarNumeroNaPilha() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float calcular(String calculo) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean validar(String text) {
		int  numeros, operadores;
        char c;
        numeros = 0;
        operadores = 0;
        for (int i = 0; i <= calculo.length(); i++) {
            c = calculo.charAt(i);
            if (Character.isAlphabetic(c)) {
                //Exeption
            } else if (c == ' ' ) {
                if (Character.isDigit(c)) {
                    numeros++;
                } else {
                    operadores++;
                }
            } else if (i == calculo.length()) {
                if (c == '-' || c == '+' || c == '*' || c == '/') {
                    operadores++;
                }
            }
        }

        if (numeros-- == operadores) {
            return true;
        }

		return false;
	}
}
