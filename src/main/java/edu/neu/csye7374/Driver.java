package edu.neu.csye7374;

import edu.neu.csye7374.factory.StockMarket;

import edu.neu.csye7374.factory.stock.FinTechStock;
import edu.neu.csye7374.factory.stock.EducationStock;
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
		Stock edn = new EducationStock("EDN", 500.0, "Edu Nova");
//		Stock wal = new ECommStock("WAL", 300.0, "Walmart");

		stockMarket.addStock(jpm);
		stockMarket.addStock(edn);

		for (double bid : new double[]{1510, 1490, 1520, 1505, 1515, 1495}) {
			stockMarket.tradeStock(jpm, String.valueOf(bid));
		}
		
		for (double bid : new double[]{490, 510, 520, 480, 495, 505}) {
			stockMarket.tradeStock(edn, String.valueOf(bid));
		}

//		for (double bid : new double[]{310, 305, 300, 295, 290, 285}) {
//			stockMarket.tradeStock(wal, String.valueOf(bid));
//		}

		stockMarket.showAllStocks();
		
		 
		System.out.println("\n\n============Main Execution End===================");
	}

}
