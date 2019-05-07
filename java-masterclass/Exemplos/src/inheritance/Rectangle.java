package inheritance;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Rectangle {
    private double width;
    private double length;

    public Rectangle(double width, double length) {
        this.width = width >= 0D ? width : 0D;
        this.length = length >= 0D ? length : 0D;
    }

    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getArea(){
        return width * length;
    }


}
