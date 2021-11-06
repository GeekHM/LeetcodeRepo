package whm.search;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-25 15:52
 **/

import org.junit.Test;

import java.util.Arrays;

/**
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 *  
 * 示例 1：
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Code_74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m - 1, mid, row;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(right<0) return false;
        row = right;
        left = 0;
        right = n - 1;// 1
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (matrix[row][mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        if(left>=n) return false;
        if (matrix[row][left] == target) return true;
        return false;
    }

    @Test
    public void test() {
        int[][] data = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(data[0].length);
    }
}
