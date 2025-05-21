package edu.neu.csye7374.factory.stock;

public class EducationStock extends Stock {
	private int totalNoOfStocks;
	public EducationStock(String name, double price, String description) {
        super(name, price, description);
        totalNoOfStocks = 1000;
    }

	@Override
	public String getMetric() {
		double marketCap = totalNoOfStocks * price;
		return String.format("Market Cap: $%.2f", marketCap);
	}

}
