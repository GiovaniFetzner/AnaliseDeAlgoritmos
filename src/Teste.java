public class Teste {

    public static void main(String[] args) {

        int[][] mat = {
                {1, 2, -1, -4, -20},
                {-8, -3, 4, 2, 1},
                {3, 8, 10, 1, 3},
                {-4, -1, 1, 7, -6}
        };

        System.out.println(maxSum2D(mat));

    }

    public static int maxSum(int[] a) {
        int result = a[0]; //get first value for correct comparison
        int sum = a[0];
        for (int i = 1; i < a.length; i++) {
            sum = Math.max(sum + a[i], a[i]); //first step getting max sum, temporary value
            result = Math.max(result, sum);
        }
        return result;
    }
    public static int maxSum2D(int array[][]){
        int result = Integer.MIN_VALUE; //result max sum
        for (int i = 0; i < array.length; i++) {
            int sum = maxSum(array[i]);
            result = Math.max(result, sum);
        }
        return result;
    }
}
