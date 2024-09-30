public class Main {

    public static void main(String[] args) {

        int[][] sourceMatrix = MatrixServices.readInputMatrix();

        int[] result = ROISolution(sourceMatrix);

        //MatrixServices.printMatrix(sourceMatrix);

        System.out.printf("\nMax sum rectangule: Sum = %d\n", result[0]);
        /*System.out.printf("Reactangle cordinates:[Top=%d, Left=%d, Bottom=%d, Right=%d]",
                result[3], result[1], result[4], result[2]);
        */
    }
        public static int[] ROISolution(int[][] sourceMatrix) {
        int rows = sourceMatrix.length;
        int columns = sourceMatrix[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[] result = new int[5]; // [maxSum, left, right, top, bottom]

        int left = 0, right = 0, top = 0, bottom = 0;

        for (int initialRow = 0; initialRow < rows; initialRow++) {
            int[] temp = new int[columns];

            for (int finalRow = initialRow; finalRow < rows; finalRow++) {

                for (int col = 0; col < columns; col++) {
                    temp[col] += sourceMatrix[finalRow][col];
                }
                int[] maxSumArray = maxSumArray(temp);
                if (maxSumArray[0] > maxSum) {
                    maxSum = maxSumArray[0];
                    left = maxSumArray[1];
                    right = maxSumArray[2];
                    top = initialRow;
                    bottom = finalRow;

                }
            }
        }
        result[0] = maxSum;
        result[1] = left;
        result[2] = right;
        result[3] = top;
        result[4] = bottom;

        return result;
    }

    public static int[] maxSumArray(int[] array) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0, initialElement = 0, finalElement = 0, temporaryInitial = 0;

        for (int i = 0; i < array.length; i++) {
            currentSum += array[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                initialElement = temporaryInitial;
                finalElement = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                temporaryInitial = i + 1;
            }
        }

        return new int[]{maxSum, initialElement, finalElement};
    }

}
