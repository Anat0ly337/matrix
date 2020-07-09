public class TestTaskAnatolyAniskevich {
    private static double summms = 0;
    private static int iterableCount = 0;

    public static void main(String[] args) {
        System.out.println("Hello, Syberry!");
        matrixGeneration(2);
        averageSum(4, 2);
        simulation(10, 3, 400, 100100);
       // simulationAlternative(10, 3, 400, 100100);
    }

    private static int[][] matrixGeneration(int n) {
        if (n > 10000 || n < 1) {
            throw new IllegalArgumentException();
        }

        int[][] array = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = (int) (Math.random() * 100);

            }
        }

        System.out.println("1.Matrix");
        for (int[] anArray : array) {
            System.out.println(toString(anArray));
        }
        return array;
    }

    private static double averageSum(int n, int m) {
        double d = n;
        double k = m;
        if (n > 10000 || n < 1 || m > n) {
            throw new IllegalArgumentException();
        }
        int[][] matrix = matrixGeneration(n);

        for (int i = 0; i <= matrix.length - m; i++) {
            for (int j = 0; j <= matrix[0].length - m; j++) {
                extractSubMatrix(matrix, i, j, m, m);
            }
        }
        System.out.println("Count of submatrix=" + " " + iterableCount);
        System.out.println("2.Average summ elements submatrix" +" "+ average());
        return average();
    }

    /**
     * @param matrix current main matrix
     * @param startX start from current cell X
     * @param startY start from current cell Y
     * @param rows   width
     * @param column height
     */
    private static void extractSubMatrix(int[][] matrix, int startX, int startY, int rows, int column) {
        int[][] submatrix = new int[column][rows];
        for (int i = startX; i < rows + startX; i++) {
            for (int j = startY; j < column + startY; j++) {
                submatrix[i - startX][j - startY] = matrix[i][j];

            }
        }
        summms = summms + summMatrix(submatrix);
        iterableCount++;
    }

    private static int summMatrix(int[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                count = count + matrix[i][i];
            }
        }
        return count;
    }

    private static double average() {
        return summms / iterableCount;
    }

    private static void simulation(int n, int m, int q, int trials) {
        if (n > 10000 || n < 1 || m > n || trials < 100 || trials > 1000000) {
            throw new IllegalArgumentException();
        }
        averageSum(n, m);
        //it depends on submatrix size
        //for example sum matrix 3x3 have a intrerval 0-900
        System.out.println("3.P = " + "" + getProbability(m, q));
    }

    //Implement a function simulation(int n, int m, int q, int trials), which in each of trials independent experiments runs averageSum(int n, int m).
    // I didn’t fully understand why to run trials, so another solve
    private static void simulationAlternative(int n, int m, int q, int trials) {
        if (n > 10000 || n < 1 || m > n || trials < 100 || trials > 1000000) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < trials; i++) {
            int k = (int) (Math.random() * 100);
            double averageSum = averageSum((int) (Math.random() * 100), k);
            System.out.println("3.P = " + " " + getProbability(m, q));
        }
    }

    private static double getProbability(int submatrixSize, int q) {
        double subMatrixSize = submatrixSize * submatrixSize;
        double maxCount = subMatrixSize * 100;
        if (maxCount < q) {
            return 0;
        }
        double result = q / maxCount * 100;
        //2 chars after .dot
        String s = String.valueOf(result);
        String i = s.substring(0, s.indexOf(".") + 3);
        result = Double.valueOf(i);
        return result;
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
