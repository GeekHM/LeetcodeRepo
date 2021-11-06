package whm2;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 07:44
 **/
//1 2 3     2 3 8 9
//4 5 6     4 5 1 2
//7 8 9     7 8 4 6        3*4
public class Code6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n1 = sc.nextInt(), n2 = sc.nextInt(), n3 = sc.nextInt();
            int[][] nums1 = getData(sc, n1, n2);
            int[][] nums2 = getData(sc, n2, n3);
            int[][] result = new int[n1][n3];
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n2; j++) {
                    for (int k = 0; k < n3; k++) {
                        result[i][k] += nums1[i][j] * nums2[j][k];
                    }
                }
            }
            for (int i = 0; i < n1; i++) {
                for (int j = 0; j < n3; j++) {
                    System.out.print(result[i][j] + " ");
                }
                System.out.println();
            }
        }
    }

    public static int[][] getData(Scanner sc, int row, int col) {
        int[][] nums = new int[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
        return nums;
    }
}
