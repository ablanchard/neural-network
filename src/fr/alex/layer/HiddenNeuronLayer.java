package fr.alex.layer;

import fr.alex.neuron.AbstractNeuron;
import fr.alex.neuron.HiddenNeuron;
import fr.alex.utils.Truth;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class HiddenNeuronLayer extends AbstractNeuronLayer<HiddenNeuron> {

    public HiddenNeuronLayer(Random r, int nbNeuron, int nbInputPerNeuron) {
        super(IntStream.range(0, nbNeuron).mapToObj(i -> new HiddenNeuron(r, nbInputPerNeuron)).collect(Collectors.toList()));
    }

    public List<AbstractNeuron.Output> train(Truth truth, List<Double> errors){
        return IntStream.range(0, neurons.size()).mapToObj(i -> neurons.get(i).train(truth, errors.get(i))).collect(Collectors.toList());
    }

}
