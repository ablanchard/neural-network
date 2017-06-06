package fr.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

import static fr.alex.Main.RANGE_MAX;
import static fr.alex.Main.RANGE_MIN;

public class NeuronLayer {

    public List<Neuron> neurons;
    public int nbInputPerNeuron;

    public NeuronLayer(Random r, int nbNeuron, int nbInputPerNeuron) {
        this.neurons = new ArrayList<>(nbNeuron);
        IntStream.range(0, nbNeuron).forEach(i -> neurons.add(new Neuron(r, nbInputPerNeuron)));
        this.nbInputPerNeuron = nbInputPerNeuron;
    }


}
