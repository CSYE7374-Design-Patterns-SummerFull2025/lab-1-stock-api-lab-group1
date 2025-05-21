package edu.neu.csye7374;

import edu.neu.csye7374.factory.StockMarket;
import edu.neu.csye7374.factory.stock.ECommStock;
import edu.neu.csye7374.factory.stock.FinTechStock;
import edu.neu.csye7374.factory.stock.EducationStock;
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

		StockMarket.demo();
		 
		System.out.println("\n\n============Main Execution End===================");
	}

}
