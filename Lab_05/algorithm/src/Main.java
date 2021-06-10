

public class Main {
    public static void main(String[] args) {
        Integer[][] matrix = {
                {Integer.MAX_VALUE, 10, 2, 10, 9, 7},
                {10, Integer.MAX_VALUE, 6, 5, 9, 10},
                {2, 6, Integer.MAX_VALUE, 10, Integer.MAX_VALUE, 15},
                {10, 5, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 3},
                {9, 9, Integer.MAX_VALUE, 5, Integer.MAX_VALUE, 12},
                {7, 10, 15, 3, 8, Integer.MAX_VALUE}};
        matrix = Algorithms.floydAlgorithm(matrix);

        System.out.println("");
        Algorithms.littleAlgorithm(matrix);
    }
}
