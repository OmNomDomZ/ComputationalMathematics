package ru.rabetskii.cubic.equation;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите коэффициент a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите коэффициент b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        double c = scanner.nextDouble();

        System.out.print("Введите коэффициент d: ");
        double d = scanner.nextDouble();

        scanner.close();
        
        GetCoefficients getCoefficients = new GetCoefficients();
        double[] coef = getCoefficients.getCoefficients(a, b, c, d);
        
        double A = coef[0];
        double B = coef[1];
        double C = coef[2];

        SolveCubicEquation solveCubicEquation = new SolveCubicEquation();
        solveCubicEquation.solve(A, B, C);
    }
}