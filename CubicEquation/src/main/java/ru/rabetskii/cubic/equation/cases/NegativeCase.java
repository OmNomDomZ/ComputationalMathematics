package ru.rabetskii.cubic.equation.cases;

import ru.rabetskii.cubic.equation.Function;
import ru.rabetskii.cubic.equation.RootFinder;

public class NegativeCase {
    private final double epsilon = 1e-5;

    public void solution(double a, double b, double c){
        Function fun = new Function();
        RootFinder rootFinder = new RootFinder(a, b, c);
        double f = fun.fun(a, b, c, 0);
        if (Math.abs(f) < epsilon){
            System.out.println("Один корень: 0");
        } else if (f < -epsilon) {
            System.out.println("Один корень: ");
            double res = rootFinder.findRootOnSemiInfiniteInterval(0,1);
            System.out.println(res);
        } else if (f > epsilon) {
            System.out.println("Один корень: ");
            double res = rootFinder.findRootOnSemiInfiniteInterval(0,-1);
            System.out.println(res);
        } else {
            System.out.println("Unknown state for D < 0");
        }
    }
}
