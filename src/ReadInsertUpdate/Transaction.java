package ReadInsert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {
    private int id;
    private String name;
    private String buyer;
    private String seller;
    private double price;
    private Date buyDate;
    private Date sellDate;

    public Transaction(int id, String name, String buyer, String seller, double price, String buyDate, String sellDate) {
        this.id = id;
        this.name = name;
        this.buyer = buyer;
        this.seller = seller;
        this.price = price;
        this.buyDate = parseDate(buyDate);
        this.sellDate = parseDate(sellDate);
    }

    private Date parseDate(String dateStr) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            System.out.println("Invalid date format: " + dateStr + ". Expected format: yyyy-MM-dd");
            return null;
        }
    }


    public int getId() { return id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getBuyer() { return buyer; }
    public String getSeller() { return seller; }
    public double getPrice() { return price; }
    public Date getBuyDate() { return buyDate; }
    public Date getSellDate() { return sellDate; }

    @Override
    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return id + "," + name + "," + buyer + "," + seller + "," + price + "," +
                sdf.format(buyDate) + "," + sdf.format(sellDate);
    }
}
