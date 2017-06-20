package fr.alex.utils;

import java.util.List;

public class Truth {

    public List<Double> inputs;

    public double expected;

    public Truth(double expected, List<Double> inputs) {
        this.expected = expected;
        this.inputs = inputs;
    }
}
