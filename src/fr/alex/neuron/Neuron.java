package fr.alex.neuron;

import fr.alex.utils.Truth;

import java.util.Random;

public class Neuron extends AbstractNeuron {

    public Neuron(Random r, int nbInput) {
        super(r, nbInput);
    }

    public Output train(Truth truth){
        Output output = new Output();
        output.output = think(truth.inputs);
        return adjustWeights(truth, output);
    }


}
