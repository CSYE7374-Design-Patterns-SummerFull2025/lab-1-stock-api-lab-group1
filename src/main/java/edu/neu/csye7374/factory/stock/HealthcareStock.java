package edu.neu.csye7374.factory.stock;

import java.util.ArrayList;
import java.util.List;

public class HealthcareStock extends Stock {

    private final List<Double> bids = new ArrayList<>();
    private static final int MAX_BIDS = 6; // Limit max bids stored

    public HealthcareStock(String name, double price, String description) {
        super(name, price, description);
    }

    // Add a bid value (as String for consistency with your pattern)
    public void addBid(String bid) {
        if (bids.size() >= MAX_BIDS) {
            System.out.println("Maximum bids reached for " + name);
            return;
        }
        try {
            double bidValue = Double.parseDouble(bid);
            bids.add(bidValue);
            updatePrice();
        } catch (NumberFormatException e) {
            System.out.println("Invalid bid: " + bid);
        }
    }

    // Update price based on average of bids
    private void updatePrice() {
        if (bids.isEmpty()) return;
        double sum = 0;
        for (double b : bids) {
            sum += b;
        }
        price = sum / bids.size();
    }

    @Override
    public String getMetric() {
        if (bids.isEmpty()) {
            return "No bids available";
        }
        double maxBid = bids.stream().mapToDouble(Double::doubleValue).max().orElse(price);
        // Example metric: difference between max bid and current price
        double metricValue = maxBid - price;
        return String.format("Bid Spread: %.2f", metricValue);
    }
}
