package ru.rabetskii.cubic.equation;

public class GetCoefficients {
    public double[] getCoefficients(double a, double b, double c, double d) {
        double A, B, C;
        A = b / a;
        B = c / a;
        C = d / a;

        return new double[] {A, B, C};
    }
}
