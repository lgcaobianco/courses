package section7.composition.room;

import section7.composition.furniture.*;

/**
 * * created by lgcaobianco on 5/4/19
 **/

public class LivingRoom {
    private Chair chair;
    private Couch couch;
    private Shelf shelf;
    private Table table;
    private Television television;

    public LivingRoom(Chair chair, Couch couch, Shelf shelf, Table table, Television television) {
        this.chair = chair;
        this.couch = couch;
        this.shelf = shelf;
        this.table = table;
        this.television = television;
    }

    public Chair getChair() {
        return chair;
    }

    public Couch getCouch() {
        return couch;
    }

    public Shelf getShelf() {
        return shelf;
    }

    public Table getTable() {
        return table;
    }

    public Television getTelevision() {
        return television;
    }

    public static void main(String[] args) {
        Chair chair = new Chair(4, "black", "Mymax", "Leather");
        Couch couch = new Couch( 2, "red", false);
        Shelf shelf = new Shelf(50, "black", "xiaomiLOL");
        Table table = new Table(4,"offbrand", "ivory", "wood");
        Television tv = new Television(46D, 5D, "silver", "LG");

        LivingRoom livingRoom = new LivingRoom(chair, couch, shelf, table, tv);
        System.out.println(livingRoom.getTelevision().getSizeInInches());
    }
}
