package task;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    @Test
    public void multiplication_test() {
        double[][] a = {
            {1, 2},
            {3, 4}
        };
        double[][] b = {
            {1, 2},
            {3, 4}
        };
        double[][] expected = {
            {7, 10},
            {15, 22}
        };
        double[][] result = Matrix.multiply(a, b);
        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void add_test_true() {
        double[][] a = {
            {2, 3},
            {2, 3}
        };
        double[][] b = {
            {2, 3},
            {2, 3}
        };
        double[][] expected = {
            {4, 6},
            {4, 6}
        };
        double[][] result = Matrix.add(a, b);
        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

    public void add_test_false() {
        double[][] a = {
            {2, 3},
            {2, 3}
        };
        double[][] b = {
            {3, 3},
            {2, 3}
        };
        double[][] expected = {
            {4, 6},
            {4, 6}
        };
        double[][] result = Matrix.add(a, b);
        Assertions.assertFalse(Arrays.deepEquals(expected, result));
    }

    @Test
    public void subtract_test_true() {
        double[][] a = {
            {1, 1},
            {2, 2}
        };
        double[][] b = {
            {1, 1},
            {2, 2}
        };
        double[][] expected = {
            {0, 0},
            {0, 0}
        };
        double[][] result = Matrix.subtract(a, b);
        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void subtract_test_false() {
        double[][] a = {
            {2, 1},
            {2, 2}
        };
        double[][] b = {
            {1, 1},
            {2, 2}
        };
        double[][] expected = {
            {0, 0},
            {0, 0}
        };
        double[][] result = Matrix.subtract(a, b);
        Assertions.assertFalse(Arrays.deepEquals(expected, result));
    }

    @Test
    public void read_matrix_from_file() {
        double[][] a = Matrix.read(getClass().getResource("/matrix1.txt").getFile());
        double[][] b = Matrix.read(getClass().getResource("/matrix2.txt").getFile());

        double[][] expected = Matrix.read(getClass().getResource("/result.txt").getFile());
        double[][] result = Matrix.multiply(a, b);

        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

}
