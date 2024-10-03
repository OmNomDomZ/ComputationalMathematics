package ru.rabetskii.cubic.equation;

import java.lang.reflect.Array;
import java.util.Arrays;

public class SolveDerivativeFun {
    private final double A;
    private final double B;
    private final double C;

    private final double D;

    public SolveDerivativeFun(double a, double b, double c) {
        A = 3;
        B = 2 * a;
        C = b;

        D = B * B - 4 * A * C;
    }

    public Discriminant getDiscriminant() {
        if (D < 0){
            return Discriminant.NEGATIVE;
        } else if (D > 0){
            return Discriminant.POSITIVE;
        } else {
            return Discriminant.ZERO;
        }
    }

    public double[] getRoots() {
        if (D > 0){
            double x1 = (-B + Math.sqrt(D)) / (2 * A);
            double x2 = (-B - Math.sqrt(D)) / (2 * A);
            double[] roots = new double[] {x1, x2};
            Arrays.sort(roots);
            return roots;
        } else {
            double x = -B / (2 * A);
            return new double[]{x};
        }
    }

}
