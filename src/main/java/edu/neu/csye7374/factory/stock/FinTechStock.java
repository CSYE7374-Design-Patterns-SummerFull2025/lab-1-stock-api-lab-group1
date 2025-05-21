package edu.neu.csye7374.factory.stock;

public class FinTechStock extends Stock {

    private final double initialPrice;

    public FinTechStock(String name, double price, String description) {
        super(name, price, description);
        this.initialPrice = price;
    }

    @Override
    public String getMetric() {
        double growthRate = ((price - initialPrice) / initialPrice) * 100;
        return String.format("Growth Rate: %.2f%%", growthRate);
    }
}
