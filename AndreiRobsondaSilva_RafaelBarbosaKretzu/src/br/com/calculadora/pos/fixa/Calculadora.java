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
	
	
	public float dividir() {
		
		try {
			float operando1 = operandos.pop();
			float operando2 = operandos.pop();		
			return operando2/operando1;
		} catch (RuntimeException e) {
			throw new RuntimeException("Calculo invalido");
		}
	}

	public float somar() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();
				
		return operando2+operando1;
	}

	public float subtrair() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();
				
		return operando2-operando1;
	}

	
	public float multiplicar() {
		float operando1 = operandos.pop();
		float operando2 = operandos.pop();
		
		return operando2*operando1;
		
	}
	
	
	public float calcular(String calculo) {
		
		String[] temp = calculo.split(" ");
		
		for (String valor : temp) {
			
			char caracter = valor.charAt(0);
			Float resultadoOperandos = null;
			switch (caracter) {
			case'+':
				resultadoOperandos = somar();
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
			default: adicionarNumeroNaPilha(converteValor(valor));
			}		
			if (resultadoOperandos != null) {
				adicionarNumeroNaPilha(resultadoOperandos);
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

	private void adicionarNumeroNaPilha(float valor) {
		operandos.push(valor);
	}

	public boolean validar(String calculo){
		int  operando, operadores;
        char c;
        operando = 0;
        operadores = 0;
        for (int i = 0; i < calculo.length(); i++) {
            c = calculo.charAt(i);
            if (Character.isAlphabetic(c)) {
                //Exeption
            } else if (c == ' ' ) {
                if (Character.isDigit(calculo.charAt(i -1))) {
                    operando++;
                } else {
                    operadores++;
                }
            } else if (i == calculo.length() -1) {
                if (c == '-' || c == '+' || c == '*' || c == '/') {
                    operadores++;
                }
            }
        }

        if ((operando-1) == operadores) {
            return true;
        }

        return false;
	}
}

