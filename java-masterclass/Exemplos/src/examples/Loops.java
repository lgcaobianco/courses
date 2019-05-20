package examples;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 4/30/19
 **/

public class Loops {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println("Veja bem, esse é um loop em java!");
        }

        // tipos de referencia não podem trablalhar com tipos primitivos
        //List<double> listQNaoFunciona = new ArrayList<>();
        // entretanto wrappers funcionam
        List<Double> listaQueFunciona = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listaQueFunciona.add(Double.valueOf(i));
        }

        // o comprimento da lista é fácil de encontrar
        System.out.println(listaQueFunciona.size());

        // pode-se usar o comprimento da lista para iterar sobre ela:
        for (int i = 0; i < listaQueFunciona.size(); i++) {
            System.out.println(listaQueFunciona.get(i));
        }

        // pode-se usar o loop avancado
        for (Double elemento : listaQueFunciona) {
            System.out.println(elemento);
        }



    }
}
