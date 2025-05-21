package edu.neu.csye7374.factory.api;

public interface Tradeable0 extends Tradeable {
    default void setBid(String bid) {
        System.out.println("Bid set to: " + bid);
    }

    default String getMetric() {
        return "Default metric calculation.";
    }
}
