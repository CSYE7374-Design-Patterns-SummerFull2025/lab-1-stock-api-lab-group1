package edu.neu.csye7374.factory;



import edu.neu.csye7374.factory.stock.*;

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

    public static void demo() {

        StockMarket stockMarket = StockMarket.getInstance();

        Stock jpm = new FinTechStock("JPM", 1000.0, "JP Morgan Chase");
        Stock wal = new ECommStock("WAL", 300.0, "Walmart");
        Stock siemens = new HealthcareStock("SIH", 100.0, "Siemens Healthineers");
        Stock msft = new TechStock("MSFT", 2000.0, "Microsoft Corporation");
        Stock edn = new EducationStock("EDN", 500.0, "Edu Nova");

        stockMarket.addStock(jpm);
        stockMarket.addStock(wal);
        stockMarket.addStock(siemens);
        stockMarket.addStock(msft);
        stockMarket.addStock(edn);

        for (double bid : new double[]{1510, 1490, 1520, 1505, 1515, 1495}) {
            stockMarket.tradeStock(jpm, String.valueOf(bid));
        }

        for (double bid : new double[]{490, 510, 520, 480, 495, 505}) {
            stockMarket.tradeStock(edn, String.valueOf(bid));
        }

        for (double bid : new double[]{310, 305, 300, 295, 290, 285}) {
            stockMarket.tradeStock(wal, String.valueOf(bid));
        }

        for (double bid : new double[]{110, 101, 104, 109, 99, 103}) {
            stockMarket.tradeStock(siemens, String.valueOf(bid));
        }

        // Tech stock with more volatile price movements to demonstrate the metric
        for (double bid : new double[]{2100, 1950, 2200, 1900, 2300, 1850}) {
            stockMarket.tradeStock(msft, String.valueOf(bid));
        }

        System.out.println("\n\n============All Stocks===================");
        stockMarket.showAllStocks();

        System.out.println("\n\n============Removing a Stock===================");
        System.out.println("Removing stock: " + jpm);
        stockMarket.removeStock(jpm);

        System.out.println("\n\n============All Stocks===================");
        stockMarket.showAllStocks();

    }
}
