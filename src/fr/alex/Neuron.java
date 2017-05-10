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

    public void train(Truth truth){
        double sumWeights = sumWeights(truth.input);
        double output = normalize(sumWeights);

        double error = truth.expected - output;

        weight1 += getAdjustment(error,truth.input.input1,output);
        weight2 += getAdjustment(error,truth.input.input2,output);
        weight3 += getAdjustment(error,truth.input.input3,output);
    }

    public double think(Input input){
        double sumWeights = sumWeights(input);
        return normalize(sumWeights);
    }

    private double sumWeights(Input input){
        return weight1*input.input1+
                weight2*input.input2+
                weight3*input.input3;
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
                "weight1=" + weight1 +
                ", weight2=" + weight2 +
                ", weight3=" + weight3 +
                '}';
    }
}
