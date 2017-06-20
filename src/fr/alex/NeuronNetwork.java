package fr.alex;

import java.util.List;

public class NeuronNetwork {

    public HiddenNeuronLayer layer1;
    public NeuronLayer layer2;

    public NeuronNetwork(HiddenNeuronLayer layer1, NeuronLayer layer2) {
        this.layer1 = layer1;
        this.layer2 = layer2;
    }

    @Override
    public String toString() {
        return "NeuronNetwork{" +
                "layer1=" + layer1 +
                ", layer2=" + layer2 +
                '}';
    }


    public void train(Truth truth){
        List<Double> thinkLayer1 = layer1.think(truth.inputs);

        Truth truthForLayer2 = new Truth(truth.expected, thinkLayer1);
        List<Neuron.Output> outputLayer2 = layer2.train(truthForLayer2);
        layer1.train(truth, outputLayer2.get(0).deltaStarWeight);

    }

    public Output think(List<Double> input){
        Output output = new Output();
        output.layer1 = layer1.think(input);
        output.layer2 = layer2.think(output.layer1).get(0);
        return output;
    }

    public class Output {
        public double layer2;
        public List<Double> layer1;

        @Override
        public String toString() {
            return "Output{" +
                    "layer2=" + layer2 +
                    ", layer1=" + layer1 +
                    '}';
        }
    }
}
