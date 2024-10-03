package ru.rabetskii.cubic.equation;

import ru.rabetskii.cubic.equation.cases.NegativeCase;
import ru.rabetskii.cubic.equation.cases.PositiveCase;
import ru.rabetskii.cubic.equation.cases.ZeroCase;

public class SolveCubicEquation {
    public void solve(double a, double b, double c) {
        Discriminant discriminant;

        SolveDerivativeFun solveDerivativeFun = new SolveDerivativeFun(a, b, c);
        discriminant = solveDerivativeFun.getDiscriminant();

        switch (discriminant){
            case NEGATIVE:
                NegativeCase negativeCase = new NegativeCase();
                negativeCase.solution(a, b, c);
                break;
            case ZERO:
                ZeroCase zeroCase = new ZeroCase();
                zeroCase.solution(a, b, c);
                break;
            case POSITIVE:
                PositiveCase positiveCase = new PositiveCase();
                positiveCase.solution(a, b, c);
                break;
        }
    }
}
