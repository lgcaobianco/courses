package composition.furniture;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Television {
    private double sizeInInches;
    private double weight;
    private String color;
    private String brand;

    public Television(double sizeInInches, double weight, String color, String brand) {
        this.sizeInInches = sizeInInches;
        this.weight = weight;
        this.color = color;
        this.brand = brand;
    }

    public double getSizeInInches() {
        return sizeInInches;
    }

    public double getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public String getBrand() {
        return brand;
    }

    public void turnOn(){
        System.out.println("the tv has been turned on!!");
    }
}
