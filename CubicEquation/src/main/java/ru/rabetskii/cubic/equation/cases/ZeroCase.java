package ru.rabetskii.cubic.equation.cases;

import ru.rabetskii.cubic.equation.Function;
import ru.rabetskii.cubic.equation.RootFinder;
import ru.rabetskii.cubic.equation.SolveDerivativeFun;

public class ZeroCase {
    private final double epsilon = 1e-5;

    public void solution(double a, double b, double c) {
        Function fun = new Function();
        RootFinder rootFinder = new RootFinder(a, b, c);

        SolveDerivativeFun solveDerivativeFun = new SolveDerivativeFun(a, b, c);

        double[] roots = solveDerivativeFun.getRoots();
        double x = roots[0];

        double value = fun.fun(a, b, c, x);

        if (value > epsilon){
            System.out.println("Один корень: ");
            double res = rootFinder.findRootOnSemiInfiniteInterval(x,-1);
            System.out.println(res);
        } else if (value < -epsilon){
            System.out.println("Один корень: ");
            double res = rootFinder.findRootOnSemiInfiniteInterval(x,1);
            System.out.println(res);
        } else if (Math.abs(value) < epsilon){
            System.out.println("Один корень кратности 3: " + x);
        } else {
            System.out.println("Unknown state for D = 0");
        }
    }
}
