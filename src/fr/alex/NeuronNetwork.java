package fr.alex;

public class NeuronNetwork {

    public NeuronLayer layer1;
    public NeuronLayer layer2;

    public NeuronNetwork(NeuronLayer layer1, NeuronLayer layer2) {
        this.layer1 = layer1;
        this.layer2 = layer2;
    }

    @Override
    public String toString() {
        return "NeuronNetwork{" +
                "layer1=" + layer1 +
                ", layer2=" + layer2 +
                '}';
    }


    public void train(Truth truth){

    }

    public void think(Input input){

    }
}
