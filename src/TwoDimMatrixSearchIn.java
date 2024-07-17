import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TwoDimMatrixSearchIn {
    public static boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length;
        int n = matrix[0].length;

        //left and right for keep start and end of matrix
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (target < midValue) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows: ");
        int rows = scanner.nextInt();
        System.out.print("Enter the number of columns: ");
        int cols = scanner.nextInt();

        List<Integer> values = new ArrayList<>();
        System.out.println("Enter the elements of the matrix:");
        for (int i = 0; i < rows * cols; i++) {
            values.add(scanner.nextInt());
        }

        // Sort values in descending order
        Collections.sort(values, Collections.reverseOrder());

        int[][] matrix = new int[rows][cols];
        int index = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = values.get(index++);
            }
        }

        System.out.println("Matrix filled in descending order:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("Enter the target value to search: ");
        int target = scanner.nextInt();

        boolean result = searchMatrix(matrix, target);
        System.out.println("Target found: " + result);
    }
}
