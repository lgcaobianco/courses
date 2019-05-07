package finaloopchallenge.burger;

import finaloopchallenge.burger.additional.Additional;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class StandardBurger {
    private String breadRollType;
    private Meat meat;
    private List<Additional> additionals;
    private String nameOfBurger;
    private Double basePrice;
    private Integer maxOfAdditional;

    public StandardBurger(String breadRollType, Meat meat, String nameOfBurger, Integer maxOfAdditional, Double basePrice) {
        this.breadRollType = breadRollType;
        this.meat = meat;
        this.nameOfBurger = nameOfBurger;
        this.maxOfAdditional = maxOfAdditional;
        this.basePrice = basePrice;
        this.additionals = new ArrayList<>();
    }

    public StandardBurger(String breadRollType, Meat meat) {
        this(breadRollType, meat, "standard", 4, 22D);
        this.additionals = new ArrayList<>();
    }

    public void addAdditional(Additional additional) {
        if (additionals.isEmpty() || additionals.size() < maxOfAdditional) {
            additionals.add(additional);
        } else {
            System.out.println("Sorry, but you have already added the maximum of additionals!");
        }
    }

    public double calculateValueOfBurger() {
        Double total = basePrice;
        if (!additionals.isEmpty()) {
            for (Additional additional : additionals) {
                total += additional.getPrice();
            }
        }
        return total;
    }

    @Override
    public String toString() {
        String stringOfAdditionals = "\n ";
        if (!additionals.isEmpty()) {
            for (Additional additional : additionals) {
                stringOfAdditionals += "\t \t - name: " + additional.getName() + "; \t price: " + additional.getPrice() + "\n";
            }
        } else {
            stringOfAdditionals = "\nNo additionals asked.";
        }
        return "Burger: \n name: "+nameOfBurger + "\n \t bread: " + breadRollType + " \n \t meat: " + meat.name() +
                " \n \t base price: " + basePrice + "\n \t Additionals: "+stringOfAdditionals;
    }

    public String getName() {
        return nameOfBurger;
    }
}

