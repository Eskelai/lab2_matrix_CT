package task;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Matrix {

    public static double[][] multiply(double[][] a, double[][] b) {
        if ((a.length == 0) || (b.length == 0) || (a[0].length != b.length)) {
            return null;
        }
        double[][] c = new double[a.length][b[0].length];
        for (int row = 0; row < c.length; row++) {
            for (int col = 0; col < c[row].length; col++) {
                for (int i = 0; i < b.length; i++) {
                    c[row][col] += a[row][i] * b[i][col];
                }
            }
        }
        return c;
    }

    public static double[][] add(double[][] a, double[][] b) {
        if ((a.length == 0) || (b.length == 0) ||
            (a.length != b.length) || (a[0].length != b[0].length)) {
            return null;
        }
        double[][] c = new double[a.length][a[0].length];
        for (int row = 0; row < c.length; ++row) {
            for (int col = 0; col < c.length; ++col) {
                c[row][col] = a[row][col] + b[row][col];
            }
        }
        return c;
    }

    public static double[][] subtract(double[][] a, double[][] b) {
        if ((a.length == 0) || (b.length == 0) ||
            (a.length != b.length) || (a[0].length != b[0].length)) {
            return null;
        }
        double[][] c = new double[a.length][a[0].length];
        for (int row = 0; row < c.length; ++row) {
            for (int col = 0; col < c.length; ++col) {
                c[row][col] = a[row][col] - b[row][col];
            }
        }
        return c;
    }


    public static double[][] read(String filePath) {
        if (filePath == null) {
            return null;
        }
        File file = new File(filePath.replaceAll("%20", " "));
        double[][] res = null;
        try {
            Scanner scn = new Scanner(file);
            int rows = scn.nextInt();
            int cols = scn.nextInt();
            res = new double[rows][cols];
            for (int row = 0; row < rows; ++row) {
                for (int col = 0; col < cols; ++col) {
                    res[row][col] = scn.nextDouble();
                }
            }
            scn.close();
        } catch (FileNotFoundException e) {
            res = null;
        } catch (InputMismatchException e) {
            res = null;
        }
        return res;
    }
}
