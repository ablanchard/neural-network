package fr.alex;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

    public static final double RANDOM_RANGE_MIN = -1;
    public static final double RANDOM_RANGE_MAX = 1;
    public static final int ITERATION = 10000;

    public static void main(String[] args) {

        List<Truth> truths = new ArrayList<>();
        truths.add(new Truth(0, 0, 1, 0));
        truths.add(new Truth(1, 1, 1, 1));
        truths.add(new Truth(1, 0, 1, 1));
        truths.add(new Truth(0, 0, 1, 0));

        Random r = new Random();

        Neuron neuron = new Neuron(random(r), random(r), random(r));

        System.out.println(neuron);

        //Training phase
        for(int i = 0 ; i < ITERATION; i++){
            neuron.train(truths.get(i%4));
        }

        System.out.println(neuron);

        //Find the answer for a new case
        System.out.println(neuron.think(new Input(1,0,0)));

    }

    private static double random(Random r){
        return RANDOM_RANGE_MIN + (RANDOM_RANGE_MAX - RANDOM_RANGE_MIN) * r.nextDouble();
    }
}
