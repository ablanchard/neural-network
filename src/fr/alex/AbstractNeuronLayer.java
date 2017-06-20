package fr.alex;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractNeuronLayer<T extends AbstractNeuron> {

    public List<T> neurons;

    public AbstractNeuronLayer(List<T> neurons) {
        this.neurons = neurons;
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
