package examples;

/**
 * * created by lgcaobianco on 4/30/19
 **/

public class Pinscher extends Cachorro {
    private String tremedeira;

    public Pinscher(int quantidadePatas, String corDoPelo, int idade, String nome) {
        super(quantidadePatas, corDoPelo, idade, nome);
        this.tremedeira = tremedeira;
    }

    @Override
    public void latir() {
        System.out.println("AAAAAAAAAAAAAAAAAA VAI TOMAR NO CU CARALHO EU VOU MATAR TODO MUNDO PORRA" +
                "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA ");
    }

    public static void main(String[] args) {
        Cachorro max = new Cachorro(4, "branco", (int) (4 / 12), "Max, chupisco, costelinha, terror");
        Cachorro nina = new Pinscher(4, "preta", 2, "nina");

        max.latir();
        nina.latir();
        System.out.println("isso demonstra que o metodo latir foi alterado para a subclasse pinscher!!");
    }
}