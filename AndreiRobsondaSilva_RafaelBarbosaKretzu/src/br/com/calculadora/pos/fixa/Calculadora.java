package br.com.calculadora.pos.fixa;

public class Calculadora {
	private Pilha<Float> operandos;
	public Calculadora(boolean isDinamica, int limite) {
		if (isDinamica) {
			operandos = new PilhaDinamica<>(limite);
		} else {
			operandos = new PilhaVetor<>(limite);
		}
	}
	
	
	public void dividir() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();		
		
		operandos.push(operando2/operando1);
	}

	public void somar() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();
				
		operandos.push(operando2+operando1);
	}

	public void subtrair() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();
				
		operandos.push(operando2-operando1);
	}

	
	public void multiplicar() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();
		
		operandos.push(operando2*operando1);
		
	}
	
	
	public float calcular(String calculo) {
		
		String[] temp = calculo.split(" ");
		
		for (String valor : temp) {
			char caracter = valor.charAt(0);
			switch (caracter) {
			case'+':
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
			default: operandos.push(converteValor(valor));
			}
		}
		
		return operandos.pop();	
	}
	
	private float converteValor(String valor) {
		try {
			return Float.parseFloat(valor);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Caracter invalido encontrado");
		}
	}

	public void validar(String calculo){
		int  operando, operadores;
        char c;
        operando = 0;
        operadores = 0;
        for (int i = 0; i < calculo.length(); i++) {
            c = calculo.charAt(i);
            if (Character.isAlphabetic(c)) {
                throw new RuntimeException("Caract�r n�o reconhecido para c�lculo");
            } else if (c == ' ' ) {
                if (Character.isDigit(calculo.charAt(i -1))) {
                    operando++;
                } else {
                    operadores++;
                }
            } else if (i == calculo.length() -1) {
                if (isOperador(c)) {
                    operadores++;
                }
            }
        }
        boolean calculoIsValid = (operando-1) == operadores;
        if (!calculoIsValid) {
            throw new RuntimeException("C�lculo inv�lido. Exemplos de c�culos v�lidos:\n"
            		+ "1 2 - 4 5 + *;\n"
            		+ "23 12 + 7 / 3 12 � 5 + *");
        }
	}


	private boolean isOperador(char c) {
		return (c == '-' || c == '+' || c == '*' || c == '/');
	}
}

