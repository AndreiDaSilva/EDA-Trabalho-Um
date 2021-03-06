package br.com.calculadora.pos.fixa;

import java.awt.event.KeyEvent;

public class Calculadora {
	private Pilha<Float> operandos;
	private static String CALCULOINVALIDO = "C?lculo inv?lido. Exemplos de c?culos v?lidos:\n" + "1 2 - 4 5 + *; \n" + "23 12 + 7 / 3 12 ? 5 + *";

	public Calculadora(boolean isDinamica, int limite) {
		if (isDinamica) {
			operandos = new PilhaDinamica<>();
		} else {
			operandos = new PilhaVetor<>(limite);
		}
	}

	public void dividir() {
		try {
			float operando1 = operandos.pop();
			float operando2 = operandos.pop();

			operandos.push(operando2 / operando1);
		} catch (RuntimeException e) {
			throw new RuntimeException(CALCULOINVALIDO);
		}
		
	}

	public void somar() {
		try {
			float operando1 = operandos.pop();
			float operando2 = operandos.pop();

			operandos.push(operando2 + operando1);
		} catch (RuntimeException e) {
			throw new RuntimeException(CALCULOINVALIDO);
		}
		
	}

	public void subtrair() {
		try {
			float operando1 = operandos.pop();
			float operando2 = operandos.pop();

			operandos.push(operando2 - operando1);
		} catch (RuntimeException e) {
			throw new RuntimeException(CALCULOINVALIDO);
		}
		
	}

	public void multiplicar() {
		try {
			float operando1 = operandos.pop();
			float operando2 = operandos.pop();

			operandos.push(operando2 * operando1);
		} catch (RuntimeException e) {
			throw new RuntimeException(CALCULOINVALIDO);
		}
		
	}

	public float calcular(String calculo) {

		String[] temp = calculo.split(" ");

		for (String valor : temp) {
			char caracter = valor.charAt(0);
			switch (caracter) {
			case '+':
				somar();
				break;
			case '-':
				subtrair();
				break;
			case '/':
				dividir();
				break;
			case '*':
				multiplicar();
				break;
			default:
				operandos.push(converteValor(valor));
			}
		}

		return operandos.pop();
	}

	private float converteValor(String valor) {
		try {			
			return Float.parseFloat(valor);
		} catch (NumberFormatException nfe) {
			throw new NumberFormatException("Caracter inv?lido encontrado");
		}

	}

	public void validar(String calculo) {
		int operando, operadores;
		char c;
		operando = 0;
		operadores = 0;
		if(calculo.isBlank()) {
			throw new RuntimeException("O campo c?lculo deve estar preenchido");
		}
		if(isOperador(calculo.charAt(0))) {
			throw new RuntimeException("C?lculo n?o pode come?ar com operador");
		}
		for (int i = 0; i < calculo.length(); i++) {
			c = calculo.charAt(i);
			if (c == ' ') {
				if (Character.isDigit(calculo.charAt(i - 1))) {
					operando++;
				} else {
					operadores++;
				}
			} else if (i == calculo.length() - 1) {
				if (isOperador(c)) {
					operadores++;
				}
			}
		}
		boolean calculoIsValid = (operando - 1) == operadores;
		if (!calculoIsValid) {
			throw new RuntimeException(CALCULOINVALIDO);
		}
	}

	private static boolean isOperador(char c) {
		return (c == '-' || c == '+' || c == '*' || c == '/');
	}

	private static boolean isVirgulaOuPonto(char c) {
		return (c == '.' || c == ',');
	}

	public static boolean isDigitoValido(char c) {
		return Character.isDigit(c) || Character.isWhitespace(c) || isVirgulaOuPonto(c) || isOperador(c)
				|| c == KeyEvent.VK_BACK_SPACE || c == KeyEvent.VK_DELETE;
	}
}
