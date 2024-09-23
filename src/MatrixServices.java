import java.util.Scanner;

public class MatrixServices {

    public static void printMatrix(int[][] sourceMatrix){

        System.out.println("\nSource matrix: ");

        for (int i = 0; i < sourceMatrix.length; i++){
            for (int j = 0; j < sourceMatrix.length; j++){
                System.out.print(sourceMatrix[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static int[][] readInputMatrix() {

        System.out.print("Inform matrix's length: ");

        Scanner scanner = new Scanner(System.in);

        int length = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Inform matrix's numbers: ");

        int[][] matrix = new int[length][length];

        for (int i = 0; i < length; i++){
            String input = scanner.nextLine();
            String[] separatedElements = input.split(" ");
            for (int j = 0; j < length; j++){
                matrix[i][j] = Integer.parseInt(separatedElements[j]);
            }
        }

        return matrix;
    }
}
