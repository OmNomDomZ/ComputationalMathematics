package ru.rabetskii.cubic.equation;

public class Function {
    public double fun(double a, double b, double c, double x) {
        return Math.pow(x, 3) + a * Math.pow(x, 2) + b * x + c;
    }
}
