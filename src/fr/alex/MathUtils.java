package fr.alex;

public class MathUtils {

    public static double normalize(double sum){
        return 1/(1+Math.exp(-sum));
    }

    public static double gradient(double output){
        return output*(1-output);
    }

    public static double getAdjustment(double error, double input, double output){
        return error*input*gradient(output);
    }

    public static double getAdjustment(double input, double delta){
        return input*delta;
    }

    public static double getDelta(double error, double output){
        return error*gradient(output);
    }
}
