package composition.furniture;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Table {
    private int amountOfFeet;
    private String brand;
    private String color;
    private String madeOf;

    public Table(int amountOfFeet, String brand, String color, String madeOf) {
        this.amountOfFeet = amountOfFeet;
        this.brand = brand;
        this.color = color;
        this.madeOf = madeOf;
    }

    private String getColor(){
        return color;
    }
}
