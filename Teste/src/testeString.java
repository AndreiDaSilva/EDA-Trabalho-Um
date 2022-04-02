public class testeString {
    public static void main(String arg[]) {

        String str = "25 85 + 12 78 + -";

        int operando, operadores;
        char c;
        operando = 0;
        operadores = 0;
        for (int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            if (Character.isAlphabetic(c)) {
                System.out.println("A Expressão conte caractere invalido!");
            } else if (c == ' ') {
                if (Character.isDigit(str.charAt(i - 1))) {
                    operando++;
                } else {
                    operadores++;
                }
            } else if (i == str.length() -1) {
                if (c == '-' || c == '+' || c == '*' || c == '/') {
                    operadores++;
                }
            }
        }

        if ((operando - 1) == operadores) {
            System.out.println("Expressão é Valida");
            System.out.println("Operandos = "+operadores);
            System.out.println("Operandos = "+operando);
        } else {

            System.out.println("Expressão não é Valida");
            System.out.println("Operandos = "+operadores);
            System.out.println("Operandos = "+operando);
        }   
        

    }

}