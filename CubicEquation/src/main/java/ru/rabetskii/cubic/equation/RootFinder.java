package ru.rabetskii.cubic.equation;

public class RootFinder {
    private final Function function = new Function();
    private final double a;
    private final double b;
    private final double c;
    private final double epsilon = 1e-5;

    public RootFinder(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double findRootOnFiniteInterval(double x1, double x2){
        return basicCalculation(x1, x2);
    }

    private double basicCalculation(double x1, double x2){
        double f1 = function.fun(a, b, c, x1);
        double f2 = function.fun(a, b, c, x2);

        while (Math.abs(f1 - f2) > epsilon){
            double z = (x1 + x2) / 2;
            double fz = function.fun(a, b, c, z);

            if (Math.abs(fz) < epsilon){
                return z;
            } else if (f1 * fz < 0){
                x2 = z;
                f2 = fz;
            } else {
                x1 = z;
                f1 = fz;
            }
        }

        return (x1 + x2) / 2;
    }

    public double findRootOnSemiInfiniteInterval(double start, double delta){
        double x1 = start;
        double x2 = x1 + delta;

        double f1 = function.fun(a, b, c, x1);
        double f2 = function.fun(a, b, c, x2);

        if (f1 == 0){
            return x1;
        }
        if (f2 == 0){
            return x2;
        }

        while (f1 * f2 > 0){
            x1 = x2;
            x2 = x2 + delta;
            f1 = f2;
            f2 = function.fun(a, b, c, x2);

            if (f2 == 0){
                return x2;
            }
        }

        return basicCalculation(x1, x2);
    }
}
