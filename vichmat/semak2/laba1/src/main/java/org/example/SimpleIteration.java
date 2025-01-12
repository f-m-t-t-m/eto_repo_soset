package org.example;

import static org.example.MatrixUtils.*;

public class SimpleIteration {

    public double[] solve(double[][] a, double[] b) {
        double[][] solveMatrix = buildSolveMatrix(a);
        double[] curX = new double[b.length];
        double[] prevX;
        int it = 0;
        do {
            ++it;
            prevX = curX;
            curX = calcNewX(a, b, prevX, solveMatrix);
        } while (Math.abs(max(prevX) - max(curX)) > 1e-6);
        System.out.println(it);
        return curX;
    }

    private double[][] buildSolveMatrix(double[][] a) {
        double[][] solveMatrix = new double[a.length][a[0].length];
        for (int i = 0; i < a.length; ++i) {
            for (int j = 0; j < a[i].length; ++j) {
                if (i == j) {
                    continue;
                }
                solveMatrix[i][j] = -a[i][j];
            }
        }
        return solveMatrix;
    }

    protected double[] calcNewX(double[][] a, double[] b, double[] oldX, double[][] solveMatrix) {
        double[] newX = new double[oldX.length];
        for (int i = 0; i < solveMatrix.length; ++i) {
            for (int j = 0; j < oldX.length; ++j) {
                newX[i] += solveMatrix[i][j] * oldX[j];
            }
            newX[i] += b[i];
            newX[i] /= a[i][i];
        }
        return newX;
    }

}
