package examples;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 4/30/19
 **/

public class Listas {
    public static void main(String[] args) {
        List<Double> listaQueFunciona = new ArrayList<>();
        // porém o que ocorre se eu fizer..
        for (Double elemento : listaQueFunciona) {
            elemento = 9999.0;
            System.out.println("atribuindo 9999.0 ao elemento");
        } // e imprimir a lista novamente????
        System.out.println("VAMOS IMPRIMIR A LISTA NOVAMENTE!!");
        for (Double elemento : listaQueFunciona) {
            System.out.println(elemento);
        }
        System.out.println("Ocorreu o esperado? Por que?");

        // um erro comum!!!!
        for (int i = 0; i < listaQueFunciona.size(); i++) {
            // DESCOMENTAR O CODIGO ABAIXO
            // listaQueFunciona.get(i) = 9999.99;
        }

        // o jeito correto
        for (Double elemento : listaQueFunciona) {
            // o método set recebe 2 parâmetros: o index do elemento a ser substituido
            // e o valor q deve ser substituido.
            listaQueFunciona.set(listaQueFunciona.indexOf(elemento), 9999.0);
        }

        // RELEMBRAR A DIFERENÇA ENTRE LISTAS E ARRAYS
    }
}
