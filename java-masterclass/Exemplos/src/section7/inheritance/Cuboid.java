package section7.inheritance;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class Cuboid extends Rectangle implements  CalculateArea {
    private double height;

    public Cuboid(double width, double length, double height){
        super(width, length);
        this.height = height >= 0D ? height : 0D;
    }

    public double getHeight() {
        return height;
    }

    public double getVolume(){
        return super.getArea() * height;
    }

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(5, 10);
        System.out.println("rectangle area: "+rectangle.getArea());
        Cuboid pool = new Cuboid(5,10,5);
        System.out.println("cuboid surface area: "+ pool.getArea());
        System.out.println("cuboid volume: "+pool.getVolume());
    }

    @Override
    public double CalculateArea(double width, double height) {
        return width * height;
    }
}
