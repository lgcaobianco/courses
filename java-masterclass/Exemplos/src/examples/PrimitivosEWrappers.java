package examples;

/**
 * * created by lgcaobianco on 4/30/19
 **/

public class PrimitivosEWrappers {
    public static void main(String[] args) {
        // variaveis primitivas:
        int numero1 = 5;
        int numero2 = 5;
        double numero3 = 5.0;
        //o q será impresso nesse caso??
        if (numero1 == numero2) {
            System.out.println("PRIMITIVOS SÃO ASSIM");
        } else {
            System.out.println("ou assim??");
        }



        String texto = "5.0";
        // variaveis de referencia
        Double var1 = Double.parseDouble(texto);
        Double var2 = 5.0;
        // mostrar metodos disponiveis em wrappers
        //var1
        System.out.println("A variavel 1 vale: " + var1 + "!!!");
        System.out.println("A variavel 2 vale: " + var2 + "!!!");
        // o q será impresso nesse caso??
        if (var1 == var2) {
            System.out.println("Isso...");
        } else {
            System.out.println("ou isso???");
        }

        // o jeito correto de comparar referências!!
        if (var1.equals(var2)) {
            System.out.println("Usando o metodo equals, " +
                    "comparamos corretamente!" +
                    "Agora sim!!!");
        }


    }
}
