package section7.composition.furniture;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Chair {
    private int amountOfLegs;
    private String color;
    private String brand;
    private String material;
    private boolean isOccupied;

    public Chair(int amountOfLegs, String color, String brand, String material) {
        this.amountOfLegs = amountOfLegs;
        this.color = color;
        this.brand = brand;
        this.material = material;
        this.isOccupied = false;
    }

    private void sitOn(){
        this.isOccupied = true;
        System.out.println("Chair has been sit on");
    }

}
