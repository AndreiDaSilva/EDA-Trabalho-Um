public class testeString {
    public static void main(String arg[]) {

        String str = "25 85 12 + -";

        int operando = 0;
        int operador = 0;

        for (int i = 0; i < str.length(); i++) {
            
            if (str.contains(" ")) {
                if (str.contains("/")) {
                    operador++;
                } else {
                    operando++;
                }

            }
        }
        System.out.println(operador);
        System.out.println(operando);
    }

}