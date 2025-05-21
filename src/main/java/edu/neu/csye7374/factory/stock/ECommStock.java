package edu.neu.csye7374.factory.stock;

public class ECommStock extends Stock {

    public ECommStock(String name, double price, String description) {
        super(name, price, description);
    }

    @Override
    public String getMetric() {
        if (bidHistory.isEmpty()) return "0.0";
        double avg = bidHistory.stream().mapToDouble(Double::doubleValue).average().orElse(0);
        double max = bidHistory.stream().mapToDouble(Double::doubleValue).max().orElse(0);
        double min = bidHistory.stream().mapToDouble(Double::doubleValue).min().orElse(0);
        double volatility = max - min;
        return String.format("Avg Bid: %.2f", avg - volatility);
    }
}
