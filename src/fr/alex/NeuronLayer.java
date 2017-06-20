package fr.alex;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NeuronLayer extends AbstractNeuronLayer<Neuron> {

    public NeuronLayer(Random r, int nbNeuron, int nbInputPerNeuron) {
        super(IntStream.range(0, nbNeuron).mapToObj(i -> new Neuron(r, nbInputPerNeuron)).collect(Collectors.toList()));
    }


    public List<Neuron.Output> train(Truth truth){
        return neurons.stream().map(n -> n.train(truth)).collect(Collectors.toList());
    }

}
