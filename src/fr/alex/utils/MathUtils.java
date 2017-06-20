package fr.alex.utils;

public class MathUtils {

    public static double activate(double sum){
        return 1/(1+Math.exp(-sum));
    }

    public static double activateDerivative(double output){
        return output*(1-output);
    }

    public static double getAdjustment(double error, double input, double output){
        return error*input* activateDerivative(output);
    }

    public static double getAdjustment(double input, double delta){
        return input*delta;
    }

    public static double getDelta(double error, double output){
        return error* activateDerivative(output);
    }
}
