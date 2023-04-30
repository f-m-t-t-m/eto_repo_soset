package org.example;


public class Main {

    public static void main(String[] args) {
        final double[][] a = {
                {5, -1, 3},
                {1, -4, 2},
                {2, -1, 5}
        };

        final double[] b = {5, 20, 10};

        beautifyPrintVector(SimpleIteration.solve(a, b));

    }

    private static void beautifyPrintVector(double[] vec) {
        for(int i = 0; i < vec.length; ++i) {
            System.out.printf("x%d = %f\n", i+1, vec[i]);
        }
    }

}