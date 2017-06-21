package fr.alex;

public class Neuron {

    public double weight1;
    public double weight2;
    public double weight3;

    public Neuron(double weight1, double weight2, double weight3) {
        this.weight1 = weight1;
        this.weight2 = weight2;
        this.weight3 = weight3;
    }

    public double think(Input input){
        double aggregation = aggregate(input);
        return activate(aggregation);
    }

    public void train(Truth truth){
        double output = think(truth.input);
        adjustWeights(truth, output);
    }

    private double aggregate(Input input){
        return weight1*input.input1+
                weight2*input.input2+
                weight3*input.input3;
    }

    private double activate(double aggregation){
        return 1/(1+Math.exp(-aggregation));
    }

    private void adjustWeights(Truth truth, double output) {
        double error = truth.expected - output;

        double delta = getDelta(error, output);
        weight1 += getAdjustment(truth.input.input1,delta);
        weight2 += getAdjustment(truth.input.input2,delta);
        weight3 += getAdjustment(truth.input.input3,delta);
    }

    private double getDelta(double error, double output) {
        return error * activateDerivative(output);
    }

    private double activateDerivative(double output){
        return output*(1-output);
    }

    private double getAdjustment(double input, double delta){
        return input * delta;
    }

    @Override
    public String toString() {
        return "Neuron{" +
                "weight1=" + weight1 +
                ", weight2=" + weight2 +
                ", weight3=" + weight3 +
                '}';
    }
}
