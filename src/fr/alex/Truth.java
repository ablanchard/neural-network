package fr.alex;

public class Truth {

    public Input input;

    public double expected;

    public Truth(double input1, double input2, double input3, double expected) {
        this.input = new Input(input1,input2,input3);
        this.expected = expected;
    }
}
