package edu.neu.csye7374.factory.api;

public interface Tradeable1 extends Tradeable {
    default String getMetric() {
        return "Default metric from Tradeable1.";
    }

}
