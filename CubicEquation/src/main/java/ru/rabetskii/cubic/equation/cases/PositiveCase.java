package ru.rabetskii.cubic.equation.cases;

import ru.rabetskii.cubic.equation.Function;
import ru.rabetskii.cubic.equation.RootFinder;
import ru.rabetskii.cubic.equation.SolveDerivativeFun;

public class PositiveCase {
    private final Function fun = new Function();

    public void solution(double a, double b, double c){
        RootFinder rootFinder = new RootFinder(a, b, c);

        SolveDerivativeFun solveDerivativeFun = new SolveDerivativeFun(a, b, c);

        double[] roots = solveDerivativeFun.getRoots();
        double x1 = roots[0];
        double x2 = roots[1];

        double f1 = fun.fun(a, b, c, x1);
        double f2 = fun.fun(a, b, c, x2);

        double epsilon = 1e-5;
        if (f1 > epsilon && f2 > epsilon && isMax(a, b, c, x1) ||
                f1 < -epsilon && f2 < -epsilon && !isMax(a, b, c, x1)) {
            System.out.println("Один корень: ");
            double root = rootFinder.findRootOnSemiInfiniteInterval(x1, -1);
            System.out.println(root);
        } else if (f1 > epsilon && f2 > epsilon && !isMax(a, b, c, x1) ||
                f1 < -epsilon && f2 < -epsilon && isMax(a, b, c, x1)) {
            System.out.println("Один корень: ");
            double root = rootFinder.findRootOnSemiInfiniteInterval(x2, 1);
            System.out.println(root);
        } else if ((f1 > epsilon && f2 < -epsilon) || (f1 < -epsilon && f2 > epsilon)) {
            System.out.println("Три различных корня: ");
            double root1 = rootFinder.findRootOnSemiInfiniteInterval(x1, -1);
            double root2 = rootFinder.findRootOnFiniteInterval(x1, x2);
            double root3 = rootFinder.findRootOnSemiInfiniteInterval(x2, 1);
            System.out.println("Корни: " + root1 + ", " + root2 + ", " + root3);
        } else if (Math.abs(f1) < epsilon) {
            System.out.println("Три корня, один из которых кратности 2: ");
            double root3 = rootFinder.findRootOnSemiInfiniteInterval(x2, 1);
            System.out.println("Корни: " + x1 + "(кратности 2)" + ", " + root3);
        } else if (Math.abs(f2) < epsilon) {
            System.out.println("Три корня, один из которых кратности 2: ");
            double root1 = rootFinder.findRootOnSemiInfiniteInterval(x1, -1);
            System.out.println("Корни: " + root1 + ", " + x2  + "(кратности 2)");
        } else {
            System.out.println("Unknown state for D > 0");
        }
    }

    private boolean isMax(double a, double b, double c, double x){
        return fun.fun(a, b, c, x) > fun.fun(a, b, c, x + 1e-5) &&
                fun.fun(a, b, c, x) > fun.fun(a, b, c, x - 1e-5);
    }
}
