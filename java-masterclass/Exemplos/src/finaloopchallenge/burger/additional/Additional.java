package finaloopchallenge.burger.additional;

import java.util.ArrayList;
import java.util.List;

/**
 * * created by lgcaobianco on 5/6/19
 **/

public class Additional {
    public static int idAdditional;
    public static int additionalsCreated;
    private String name;
    private Double price;

    public Additional(String name, Double price) {
        this.name = name;
        this.price = price;
        this.idAdditional = additionalsCreated;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return " \t\t - name: " + name + ", price: " + price;
    }
}
