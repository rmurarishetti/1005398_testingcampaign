package Yogesh;

public class Entry implements Comparable {
    private String id;
    private int tempID;
    private String accountNumber;
    private String currency;
    private String type;
    private String balance;

    public Entry(String id, String accountNumber, String currency, String type, String balance) {
        this.id = id;
        this.tempID = Integer.parseInt(id.substring(2));
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.type = type;
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Entry:" + id;
    }

    @Override
    public int compareTo(Object o) {
        Entry comparee = (Entry)o;
        return Integer.compare(this.tempID, comparee.tempID);
    }
}