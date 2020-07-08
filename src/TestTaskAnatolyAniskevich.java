
public class TestTaskAnatolyAniskevich {
    public static void main(String[] args) {
        averageSum(5, 5);
    }

    private static int[][] matrixGeneration(int n) {
        if (n > 10000) {
            throw new IllegalArgumentException();
        }

        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 100);
            }
        }
        return array;
    }


    private static void averageSum(int n, int m) {
        int[][] matrix = matrixGeneration(10);
        int[][] submatrix = extractSubMatrix(matrix, m, m);
    }

    private static int[][] extractSubMatrix(int[][] matrix, int rows, int column) {
        int[][] submatrix = new int[column][rows];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                submatrix[i][j] = matrix[i][j];
            }
        }
        return submatrix;
    }

    private static void average(int m,int n){

    }



    // without external libraries except java.lang
    private static String toString(int[] a) {
        if (a == null)
            return "null";
        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; ; i++) {
            b.append(a[i]);
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
    }
}
