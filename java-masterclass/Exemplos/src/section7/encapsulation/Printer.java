package section7.encapsulation;

/**
 * * created by lgcaobianco on 5/5/19
 **/
// Create a class and demonstate proper section7.encapsulation techniques
// the class will be called Printer
// It will simulate a real Computer Printer
// It should have fields for the toner Level, number of pages printed, and
// also whether its a duplex printer (capable of printing on both sides of the paper).
// Add methods to fill up the toner (up to a maximum of 100%), another method to
// simulate printing a page (which should increase the number of pages printed).
// Decide on the scope, whether to use constructors, and anything else you think is needed.

public class Printer {
    private  String model;
    private static int printerCounter;
    private double tonerLevel;
    private int pagesPrinted;
    private boolean isDuplexPrinter;
    private double maxTonerLevel;
    private int idPrinter;

    public Printer(String model, boolean isDuplexPrinter, double maxTonerLevel) {
        this.model = model;
        this.tonerLevel = 0;
        this.pagesPrinted = 0;
        this.isDuplexPrinter = isDuplexPrinter;
        this.maxTonerLevel = maxTonerLevel;
        this.idPrinter = printerCounter++;
    }

    public double fillToner(double amount) {
        double capacity = maxTonerLevel - tonerLevel;
        double leftOver = amount > capacity ? amount - capacity : 0D;
        tonerLevel = leftOver == 0 ? amount : maxTonerLevel;
        System.out.println("There has been a leftover of " + leftOver + " toner");
        return leftOver;
    }

    public void consumeToner() {
        tonerLevel = tonerLevel - 0.5;
    }

    private boolean printPage() {
        if (tonerLevel >= 1) {
            consumeToner();
            pagesPrinted++;
            System.out.println("page printed with success.");
            return true;
        }
        System.out.println("You need to refill the tank!!!");
        return false;
    }

    public void printPages(int amount) {
        for (int i = 0; i < amount; i++) {
            if(!printPage()){
                System.out.println("CANNOT CONTINUE PRINTING FILE!!!");
                System.out.println("PRINTING HAS BEEN INTERRUPTED ON PAGE "+ (i+1));
                break;
            }
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public static int getPrinterCounter() {
        return printerCounter;
    }

    public static void setPrinterCounter(int printerCounter) {
        Printer.printerCounter = printerCounter;
    }

    public double getTonerLevel() {
        return tonerLevel;
    }

    public void setTonerLevel(double tonerLevel) {
        this.tonerLevel = tonerLevel;
    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }

    public void setPagesPrinted(int pagesPrinted) {
        this.pagesPrinted = pagesPrinted;
    }

    public boolean isDuplexPrinter() {
        return isDuplexPrinter;
    }

    public void setDuplexPrinter(boolean duplexPrinter) {
        isDuplexPrinter = duplexPrinter;
    }

    public double getMaxTonerLevel() {
        return maxTonerLevel;
    }

    public void setMaxTonerLevel(double maxTonerLevel) {
        this.maxTonerLevel = maxTonerLevel;
    }

    public int getIdPrinter() {
        return idPrinter;
    }

    public void setIdPrinter(int idPrinter) {
        this.idPrinter = idPrinter;
    }

    @Override
    public String toString() {
        return "printer id " + idPrinter + " is of model " + model + ". It has printed: "
                + pagesPrinted + " and currently has " + tonerLevel + " out of " + maxTonerLevel + ".";
    }
}
