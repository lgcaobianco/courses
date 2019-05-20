package examples;

/**
 * * created by lgcaobianco on 4/30/19
 **/

public class Cachorro {
    private int quantidadePatas;
    private Integer quantidadePatasWrapper;
    private String corDoPelo;
    private int idade;
    private String nome;
    private static int idCachorro = 0;

    // veja o que é um construtor
    public Cachorro() {
        System.out.println("Ue, esse cachorro não tem patas??");
    }

    // veja como é possível definir métodos com o MESMO NOME!!
    public Cachorro(int quantidadePatas, String corDoPelo, int idade, String nome) {
        // é no construtor que inicializamos as variaveis.
        System.out.println(quantidadePatas);
        System.out.println(this.quantidadePatas);
        this.quantidadePatas = quantidadePatas;
        this.quantidadePatasWrapper = quantidadePatas;
        this.corDoPelo = corDoPelo;
        this.idade = idade;
        this.nome = nome;
        this.idCachorro++;
    }


    public void latir() {
        System.out.println(nome +"Au au au!!");
    }

    public static void main(String[] args) {
        Cachorro cachorroQueNaoExiste = new Cachorro();
        System.out.println("O valor da id cachorro é: " + idCachorro);
        Cachorro nina = new Cachorro(4, "preta", 2, "nina");
        nina.latir();
        System.out.println("O valor da id cachorro agora é: " + idCachorro);
        Cachorro max = new Cachorro(4, "branco", 3 / 12, "Max, chupisco, costelinha, terror");
        System.out.println("O valor da id cachorro é: " + idCachorro);
        max.latir();
        System.out.println(nina.quantidadePatas == max.quantidadePatas);
        System.out.println(nina == max);

        System.out.println("Os nomes possiveis pra nina: " + nina.nome);
        System.out.println("Os nomes possiveis pro max: " + max.nome);

        max.latir();
        System.out.println(Cachorro.idCachorro);
    }
}
