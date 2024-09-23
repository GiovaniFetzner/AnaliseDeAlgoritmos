import java.util.Arrays;

public class Solution01 {

    public static void main(String[] args) {

        int[][] sourceMatrix = MatrixServices.readInputMatrix();

        int[] result = ROISolution(sourceMatrix);

        MatrixServices.printMatrix(sourceMatrix);

        System.out.printf("\nMax sum rectangule: Sum = %d\n", result[0]);
        System.out.printf("Reactangle cordinates:[Top=%d, Left=%d, Bottom=%d, Right=%d]",
                result[3], result[1], result[4], result[2]);

        /*
        int[] teste = {-1, 8, -7, 8};
        System.out.println(Arrays.toString(maxSumArray(teste)));

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

                //Aqui é onde a acontece a verificação principal. com a soma dos vetores lineares é pego o novo retângulo entre eles
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
        /*
            Esse método encontra a maior soma dentro de um vetor linear, na sua execução o elemento é adicionado
        a soma atual e se essa soma for menor que 0, o elemento é ignorado e a soma vai para o próximo da fila,
        entretanto se a soma for maior que o atual, salva a soma e marca o elemento como final do retângulo
        OBS.: Existem três condições nesse código:
            1 - A soma atual é maior do que a referência antiga, ou seja,é marcado os índices iniciais e finais do
        retângulo;
            2 - A soma é menor do que 0, ou seja, foi somado um número que não vale a pena adicionar no retângulo,
        nesse momento a referência inicial do retângulo é o próximo elemento;
            3 - Se foi somado um valor que diminuiu e que não ultrapassou 0, ele é ignorado para que a referência
        final do retângulo continue a aumentar até acontecer a próxima verificação de soma.

        Caso de teste: int[] teste = {-1, 8, -7, 8};   saída: 8 + (-7) + 8 = 9

         */
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

    public static int[] kadane2D(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[] result = new int[5]; // Guarda [maxSum, left, right, top, bottom]

        // Inicializa as bordas do retângulo
        int left = 0, right = 0, top = 0, bottom = 0;

        // Percorre todas as combinações de linhas (fixando a linha superior e inferior)
        for (int startRow = 0; startRow < rows; startRow++) {
            int[] temp = new int[cols]; // Array temporário para colapsar as colunas

            for (int endRow = startRow; endRow < rows; endRow++) {
                // Adiciona os valores da linha atual ao array temporário
                for (int col = 0; col < cols; col++) {
                    temp[col] += mat[endRow][col];
                }

                // Aplica o algoritmo de Kadane no array colapsado
                int[] kadaneResult = kadane1D(temp);

                // Se a soma máxima encontrada for maior que a anterior, atualiza o resultado
                if (kadaneResult[0] > maxSum) {
                    maxSum = kadaneResult[0];
                    left = kadaneResult[1];
                    right = kadaneResult[2];
                    top = startRow;
                    bottom = endRow;
                }
            }
        }


        // Armazena os resultados: [maxSum, left, right, top, bottom]
        result[0] = maxSum;
        result[1] = left;
        result[2] = right;
        result[3] = top;
        result[4] = bottom;

        return result;
    }

    // Função para encontrar o subarray de soma máxima em um array 1D
    public static int[] kadane1D(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int start = 0, end = 0, tempStart = 0;

        for (int i = 0; i < arr.length; i++) {
            currentSum += arr[i];

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }

            if (currentSum < 0) {
                currentSum = 0;
                tempStart = i + 1;
            }
        }

        return new int[]{maxSum, start, end}; // [maxSum, left, right]
    }
}
