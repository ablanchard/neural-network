package fr.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static fr.alex.Main.RANGE_MAX;
import static fr.alex.Main.RANGE_MIN;

public class Neuron {

    public List<Double> weights;

    public Neuron(Random r, int nbInput) {
        this.weights = new ArrayList<>(nbInput);
        IntStream.range(0, nbInput).forEach(i -> this.weights.add(random(r)));
    }

    public void train(Truth truth){
        double output = think(truth.inputs);
        adjustWeights(truth, output);
    }

    private void adjustWeights(Truth truth, double output) {
        double error = truth.expected - output;
        IntStream.range(0, weights.size() - 1).forEach(i -> weights.set(i, weights.get(i) + getAdjustment(error, truth.inputs.get(i), output)));
    }

    public double think(List<Double> input){
        double sumWeights = sumWeights(input);
        return normalize(sumWeights);
    }

    private double sumWeights(List<Double> input){
        return IntStream.range(0, weights.size() - 1).mapToDouble(i -> weights.get(i)*input.get(i)).sum();
    }

    private double normalize(double sum){
        return 1/(1+Math.exp(-sum));
    }

    private double gradient(double output){
        return output*(1-output);
    }

    private double getAdjustment(double error, double input, double output){
        return error*input*gradient(output);
    }


    @Override
    public String toString() {
        return "Neuron{" +
                "weights=" + weights +
                '}';
    }

    private static double random(Random r){
        return RANGE_MIN + (RANGE_MAX - RANGE_MIN) * r.nextDouble();
    }
}
