package task;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
    public void incorrect_files_read() {
        double[][] a = Matrix.read("data/incorrect.txt");
        Assertions.assertTrue(Arrays.deepEquals(null, a));
    }

    @Test
    public void read_matrix_from_file() {
        double[][] a = Matrix.read(getClass().getResource("/matrix1.txt").getFile());
        double[][] b = Matrix.read(getClass().getResource("/matrix2.txt").getFile());
        double[][] expected = Matrix.read(getClass().getResource("/matrix3.txt").getFile());
        double[][] result = Matrix.multiply(a, b);
        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

    @ParameterizedTest
    @CsvSource({
            "1,+,2.23", "1,-,2.23", "1,*,2.23",
            "0,*,2"   , "2,*,0"   , "0,*,0"
    })
    void operations_with_1x1_matrix_equal_number_operations(String x, String op, String y) {
        double[][] a = {{Double.parseDouble(x)}};
        double[][] b = {{Double.parseDouble(y)}};
        double[][] expected = a;
        double[][] result = null;
        switch (op) {
            case "+":
                result = Matrix.add(a, b);
                expected[0][0] += b[0][0];
                break;
            case "-":
                result = Matrix.subtract(a, b);
                expected[0][0] -= b[0][0];
                break;
            case "*":
                result = Matrix.multiply(a, b);
                expected[0][0] *= b[0][0];
                break;
            default:
                Assertions.assertTrue(false);
        }
        Assertions.assertTrue(Arrays.deepEquals(expected, result));
    }

    @Test
    public void can_work_with_different_matrix_sizes() {
        double[][] a = {
            {1, 2},
            {3, 4}
        };
        double[][] b = {
            {1, 2, 3},
            {3, 4, 5}
        };
        double[][] resultAdd = Matrix.add(a, b);
        double[][] resultSub = Matrix.subtract(a, b);
        double[][] resultMlp = Matrix.subtract(a, b);
        Assertions.assertTrue(Arrays.deepEquals(null, resultAdd));
        Assertions.assertTrue(Arrays.deepEquals(null, resultSub));
        Assertions.assertTrue(Arrays.deepEquals(null, resultMlp));
    }

    @Test
    public void zero_size_matrix_test() {
        double[][] a = {
            {1, 2},
            {3, 4}
        };
        double[][] b = {};
        double[][] answerAdd = Matrix.add(a, b);
        double[][] answerSub = Matrix.subtract(a, b);
        double[][] answerMlp = Matrix.subtract(a, b);
        Assertions.assertTrue(Arrays.deepEquals(null, answerAdd));
        Assertions.assertTrue(Arrays.deepEquals(null, answerSub));
        Assertions.assertTrue(Arrays.deepEquals(null, answerMlp));
    }
}
