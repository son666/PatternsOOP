package lesson03.singleton;

public class Dishes {
    private byte tableNumber;

    public Dishes(byte tableNumber) {
        this.tableNumber = tableNumber;
    }

    public byte getTableNumber() {
        return tableNumber;
    }
}
