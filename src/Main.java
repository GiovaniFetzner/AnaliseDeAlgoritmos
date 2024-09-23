import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {

    /*
            Algoritmo se baseia em encontrar o maior valor dentro da matriz
        e a partir dele começar a avaliar os vizinhos se vale a pena ou não expandir o retângulo.
     */
    public static void main(String[] args) {

        int[][] matrix = MatrixServices.readInputMatrix();

        int maxElement = findMaxElement(matrix);
        int[] maxElementPosition = findPosition(matrix);

        System.out.println("\nMax value from matrix: " + maxElement);
        System.out.println("Position: " + Arrays.toString(maxElementPosition));

        System.out.println("Max sum rectangle: " + ROISolution(matrix, maxElement, maxElementPosition));

        MatrixServices.printMatrix(matrix);
    }

    private static int ROISolution(int[][] source, int maxElement, int[] maxElementPosition){

        /*
        1) Encontrar o maior valor;
        2) Conseguir a posição desse elemento;
        3) Tenta expandir > Norte < Sul em uma posição
            Valor antigo (antes da expansão deve ser usado como referência), se o valor da expansão aumentou em relação
            ao valor referência, a expansão ocorre até esse aumento
                OBS.: Está complicando no momento da expansão, é mais trabalhoso e não consegue expandir corretamente
        seria mas fácil se fosse em formato de cruz a partir do maior elemento do vetor
                OBS1.: Se houver o maior valor na matriz 2D duplicado, ele vai encontrar somente um deles, que seria
        o último a ser lido, resultando em problemas na análise.

         */

        int rows = source.length;
        int columns = source[0].length;
        int maxSum = Integer.MIN_VALUE;
        int[] result = new int[5];

        // Inicializa as bordas do retângulo
        int left = 0, right = 0, top = 0, bottom = 0;



        return 0;
    }

    private static int[] findPosition(int[][] sourceMatrix){
        int maxValue = findMaxElement(sourceMatrix);

        for (int i = 0; i < sourceMatrix.length; i++){
            for (int j = 0; j < sourceMatrix.length; j++) {
                if (sourceMatrix[i][j] == maxValue){
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    private static int findMaxElement(int[][] sourceMatrix){
        //Possível melhoria: ao encontrar o elemento, colocar ele no HashMap contendo o valor e a posição
        // HashMap<Integer, ArrayList<Integer>> element

        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < sourceMatrix.length; i++){
            for (int j = 0; j < sourceMatrix.length; j++) {
                if (sourceMatrix[i][j] > maxValue){
                    maxValue = sourceMatrix[i][j];
                }
            }
        }
        return maxValue;
    }
}