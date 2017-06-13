package fr.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static fr.alex.Main.RANGE_MAX;
import static fr.alex.Main.RANGE_MIN;

public class NeuronLayer {

    public List<Neuron> neurons;

    public NeuronLayer(Random r, int nbNeuron, int nbInputPerNeuron) {
        this.neurons = new ArrayList<>(nbNeuron);
        IntStream.range(0, nbNeuron).forEach(i -> neurons.add(new Neuron(r, nbInputPerNeuron)));
    }


    public List<Neuron.Output> train(Truth truth){
        return neurons.stream().map(n -> n.train(truth)).collect(Collectors.toList());
    }

    public List<Neuron.Output> train(Truth truth, List<Double> errors){
        return IntStream.range(0, neurons.size() -1).mapToObj(i -> neurons.get(i).train(truth, errors.get(i))).collect(Collectors.toList());
    }

    public List<Double> think(List<Double> input){
        return neurons.stream().map(n -> n.think(input)).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "NeuronLayer{" +
                "neurons=" + neurons +
                '}';
    }
}
