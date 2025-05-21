package edu.neu.csye7374.factory.stock;



import edu.neu.csye7374.factory.api.Tradeable;

import java.util.ArrayList;
import java.util.List;

public abstract class Stock implements Tradeable {
    protected String name;
    protected double price;
    protected String description;
    protected List<Double> bidHistory = new ArrayList<>();

    public Stock(String name, double price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public void setBid(String bid) {
        double bidValue = Double.parseDouble(bid);
        bidHistory.add(bidValue);
        price = (price + bidValue) / 2;
        System.out.println(this.toString() + "; Bid set to: " + bid);
    }

    @Override
    public String toString() {
        return "Stock{name='" + name + "', price=" + price + ", description='" + description + "', metric=" + getMetric() + '}';
    }
}
