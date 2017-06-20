package fr.alex;

import java.util.Random;

public class HiddenNeuron extends AbstractNeuron {

    public HiddenNeuron(Random r, int nbInput) {
        super(r, nbInput);
    }

    public Output train(Truth truth, double error){
        Output output = new Output();
        output.error = error;
        output.output = think(truth.inputs);
        return adjustWeights(truth, output);
    }

}
