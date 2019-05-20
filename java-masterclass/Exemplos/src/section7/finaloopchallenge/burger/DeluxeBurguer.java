package section7.finaloopchallenge.burger;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class DeluxeBurguer extends StandardBurger{
    private boolean hasFries = true;
    private boolean hasDrinks = true;

    public DeluxeBurguer(String breadRollType, Meat meat) {
        super(breadRollType, meat, "deluxe",0, 32.50D);
    }
}
