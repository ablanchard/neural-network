package fr.alex.neuron;

import fr.alex.utils.Truth;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.alex.Main.RANGE_MAX;
import static fr.alex.Main.RANGE_MIN;
import static fr.alex.utils.MathUtils.*;

public abstract class AbstractNeuron {

    public List<Double> weights;

    public AbstractNeuron(Random r, int nbInput) {
        this.weights = new ArrayList<>(nbInput);
        IntStream.range(0, nbInput).forEach(i -> this.weights.add(random(r)));
    }

    public double think(List<Double> input){
        double aggregation = aggregate(input);
        return activate(aggregation);
    }

    private double aggregate(List<Double> input){
        return IntStream.range(0, weights.size()).mapToDouble(i -> weights.get(i)*input.get(i)).sum();
    }

    protected Output adjustWeights(Truth truth, Output output) {
        if(output.error == null){
            output.error = truth.expected - output.output;
        }
        output.delta = getDelta(output.error, output.output);
        output.deltaStarWeight = IntStream.range(0, weights.size()).mapToObj(i -> weights.get(i)*output.delta).collect(Collectors.toList());

        IntStream.range(0, weights.size()).forEach(i -> weights.set(i, weights.get(i) + getAdjustment(truth.inputs.get(i), output.delta)));
        return output;
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
