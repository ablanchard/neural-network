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


    public void train(Truth truth){

    }

    public List<Double> think(List<Double> input){
        return neurons.stream().map(n -> n.think(input)).collect(Collectors.toList());
    }


}
