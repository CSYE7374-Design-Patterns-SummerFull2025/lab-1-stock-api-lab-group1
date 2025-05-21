package edu.neu.csye7374.factory;



import edu.neu.csye7374.factory.stock.Stock;

import java.util.ArrayList;
import java.util.List;

public class StockMarket {
    private static StockMarket instance;
    private final List<Stock> stocks = new ArrayList<>();

    private StockMarket() {
        instance = null;
    }

    public static synchronized StockMarket getInstance() {
        if (instance == null) {
            instance = new StockMarket();
        }
        return instance;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
    }

    public void tradeStock(Stock stock, String bid) {
        stock.setBid(bid);
    }

    public void showAllStocks() {
        stocks.forEach(System.out::println);
    }
}
