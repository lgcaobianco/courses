package section7.encapsulation;

/**
 * * created by lgcaobianco on 5/5/19
 **/

public class Main {
    public static void main(String[] args) {
        Printer printer = new Printer("L395", false, 100);
        System.out.println(printer);
        printer.setModel("L395P");
        System.out.println(printer);
        printer.fillToner(20);
        printer.printPages(100);
        System.out.println(printer.getModel());
        System.out.println(printer.isDuplexPrinter());

        System.out.println(printer);
        Printer printer2 = new Printer("HP PROFESSIONAL ", true, 500);
        System.out.println(printer2);

    }
}
