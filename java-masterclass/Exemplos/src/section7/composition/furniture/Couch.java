package section7.composition.furniture;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Couch {
    public int amountOfSeats;
    public String color;
    public boolean isLeather;

    public Couch(int amountOfSeats, String color, boolean isLeather) {
        this.amountOfSeats = amountOfSeats;
        this.color = color;
        this.isLeather = isLeather;
    }
}
