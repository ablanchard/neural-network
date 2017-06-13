package fr.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

import static fr.alex.Main.RANGE_MAX;
import static fr.alex.Main.RANGE_MIN;
import static fr.alex.MathUtils.getAdjustment;
import static fr.alex.MathUtils.getDelta;
import static fr.alex.MathUtils.normalize;

public class Neuron {

    public List<Double> weights;

    public Neuron(Random r, int nbInput) {
        this.weights = new ArrayList<>(nbInput);
        IntStream.range(0, nbInput).forEach(i -> this.weights.add(random(r)));
    }

    public Output train(Truth truth){
        Output output = new Output();
        output.output = think(truth.inputs);
        return adjustWeights(truth, output);
    }

    public Output train(Truth truth, double error){
        Output output = new Output();
        output.error = error;
        output.output = think(truth.inputs);
        return adjustWeights(truth, output);
    }

    private Output adjustWeights(Truth truth, Output output) {
        if(output.error == null){
            output.error = truth.expected - output.output;
        }
        output.delta = getDelta(output.error, output.output);
        output.deltaStarWeight = IntStream.range(0, weights.size() - 1).mapToObj(i -> weights.get(i)*output.delta).collect(Collectors.toList());

        IntStream.range(0, weights.size() - 1).forEach(i -> weights.set(i, weights.get(i) + getAdjustment(output.error, truth.inputs.get(i), output.output)));
        return output;
    }

    public double think(List<Double> input){
        double sumWeights = sumWeights(input);
        return normalize(sumWeights);
    }

    private double sumWeights(List<Double> input){
        return IntStream.range(0, weights.size() - 1).mapToDouble(i -> weights.get(i)*input.get(i)).sum();
    }

    public class Output {
        public double output;
        public double delta;
        public Double error;
        public List<Double> deltaStarWeight;
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
