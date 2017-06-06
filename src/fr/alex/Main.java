package fr.alex;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Main {

    public static final double RANGE_MIN = -1;
    public static final double RANGE_MAX = 1;
    public static final int ITERATION = 10000;
    public static final int ITERATION_2 = 60000;

    public static void main(String[] args) {

        exampleWithOneNeuron();



    }

//    private static void exampleWithOneNeuronNetwork() {
//        List<Truth> truths = new ArrayList<>();
//        truths.add(new Truth(0L, 0L, 1L, 0L));
//        truths.add(new Truth(0L, 1L, 1L, 1L));
//        truths.add(new Truth(1L, 0L, 1L, 1L));
//        truths.add(new Truth(0L, 1L, 0L, 1L));
//        truths.add(new Truth(1L, 0L, 0L, 1L));
//        truths.add(new Truth(1L, 1L, 1L, 0L));
//        truths.add(new Truth(0L, 0L, 0L, 0L));
//
//        Random r = new Random();
//
//        NeuronLayer layer1 = new NeuronLayer(random(r), 4, 3);
//        NeuronLayer layer2 = new NeuronLayer(random(r), 1, 4);
//
//        NeuronNetwork network = new NeuronNetwork(layer1, layer2);
//
//        System.out.println(network);
//
//        //Training phase
//        for(int i = 0 ; i < ITERATION_2; i++){
//            network.train(truths.get(i%7));
//        }
//
//        System.out.println(network);
//
//        //Find the answer for a new case
//        System.out.println(network.think(new Input(1L,0L,0L)));
//    }

    private static void exampleWithOneNeuron() {
        List<Truth> truths = new ArrayList<>();
        truths.add(new Truth(0.0, Arrays.asList(0.0, 0.0, 1.0)));
        truths.add(new Truth(1.0, Arrays.asList(1.0, 1.0, 1.0)));
        truths.add(new Truth(1.0, Arrays.asList(1.0, 0.0, 1.0)));
        truths.add(new Truth(0.0, Arrays.asList(0.0, 1.0, 1.0)));

        Random r = new Random();

        Neuron neuron = new Neuron(r, 3);

        System.out.println(neuron);

        //Training phase
        for(int i = 0 ; i < ITERATION; i++){
            neuron.train(truths.get(i%4));
        }

        System.out.println(neuron);

        //Find the answer for a new case
        System.out.println(neuron.think(Arrays.asList(1.0,0.0,0.0)));
    }

}
