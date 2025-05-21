package edu.neu.csye7374;

import edu.neu.csye7374.factory.StockMarket;
import edu.neu.csye7374.factory.stock.ECommStock;
import edu.neu.csye7374.factory.stock.FinTechStock;
import edu.neu.csye7374.factory.stock.HealthcareStock;
import edu.neu.csye7374.factory.stock.TechStock;
import edu.neu.csye7374.factory.stock.Stock;

/**
 * 
 * @author Yash Zaveri
 * 
 */

public class Driver {
	public static void main(String[] args) {
		System.out.println("============Main Execution Start===================\n\n");

		StockMarket stockMarket = StockMarket.getInstance();

		Stock jpm = new FinTechStock("JPM", 1000.0, "JP Morgan Chase");
		Stock wal = new ECommStock("WAL", 300.0, "Walmart");
		Stock siemens = new HealthcareStock("SIH", 100.0, "Siemens Healthineers");
		Stock msft = new TechStock("MSFT", 2000.0, "Microsoft Corporation");

		stockMarket.addStock(jpm);
		stockMarket.addStock(wal);
		stockMarket.addStock(siemens);
		stockMarket.addStock(msft);

		for (double bid : new double[]{1510, 1490, 1520, 1505, 1515, 1495}) {
			stockMarket.tradeStock(jpm, String.valueOf(bid));
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

		stockMarket.showAllStocks();
		 
		System.out.println("\n\n============Main Execution End===================");
	}

}
