package examples;

/**
 * * created by lgcaobianco on 4/30/19
 **/

public class ExemploThis {
    private String atributo;

    public ExemploThis(String atributo){
        System.out.println(atributo);
        System.out.println(this.atributo);
    }

    public static void main(String[] args) {
        ExemploThis exemplo = new ExemploThis("ue, onde foi parar esse texto?");
        System.out.println(exemplo.atributo);
    }
}
