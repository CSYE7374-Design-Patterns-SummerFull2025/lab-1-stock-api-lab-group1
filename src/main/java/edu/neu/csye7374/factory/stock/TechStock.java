package edu.neu.csye7374.factory.stock;

import java.util.List;

public class TechStock extends Stock {
    private final double initialPrice;
    private static final int MOMENTUM_WINDOW = 3; // Number of recent bids to consider for momentum

    public TechStock(String name, double price, String description) {
        super(name, price, description);
        this.initialPrice = price;
    }

    @Override
    public String getMetric() {
        if (bidHistory.isEmpty()) return "0.0";
        
        // Calculate momentum based on recent price changes
        double momentum = calculateMomentum();
        
        // Calculate volatility
        double volatility = calculateVolatility();
        
        // Calculate price trend strength
        double trendStrength = calculateTrendStrength();
        
        // Combine metrics with weights
        double techMetric = (momentum * 0.4) + (volatility * 0.3) + (trendStrength * 0.3);
        
        return String.format("Tech Score: %.2f (Momentum: %.2f, Volatility: %.2f, Trend: %.2f)", 
            techMetric, momentum, volatility, trendStrength);
    }
    
    private double calculateMomentum() {
        if (bidHistory.size() < 2) return 0.0;
        
        List<Double> recentBids = bidHistory.subList(
            Math.max(0, bidHistory.size() - MOMENTUM_WINDOW), 
            bidHistory.size()
        );
        
        double momentum = 0.0;
        for (int i = 1; i < recentBids.size(); i++) {
            momentum += (recentBids.get(i) - recentBids.get(i-1)) / recentBids.get(i-1);
        }
        return momentum * 100; // Convert to percentage
    }
    
    private double calculateVolatility() {
        if (bidHistory.size() < 2) return 0.0;
        
        double mean = bidHistory.stream()
            .mapToDouble(Double::doubleValue)
            .average()
            .orElse(0.0);
            
        double variance = bidHistory.stream()
            .mapToDouble(bid -> Math.pow(bid - mean, 2))
            .average()
            .orElse(0.0);
            
        return Math.sqrt(variance);
    }
    
    private double calculateTrendStrength() {
        if (bidHistory.size() < 2) return 0.0;
        
        double firstPrice = bidHistory.get(0);
        double lastPrice = bidHistory.get(bidHistory.size() - 1);
        double priceChange = ((lastPrice - firstPrice) / firstPrice) * 100;
        
        return Math.max(-1.0, Math.min(1.0, priceChange / 100.0));
    }
} 