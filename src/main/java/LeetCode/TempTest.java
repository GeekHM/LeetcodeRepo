package LeetCode;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-07 10:37
 **/
public class TempTest {
    public static void main(String[] args) {
        int binary = findBinary(4);
        System.out.println(binary);
    }

    public static int findBinary(int nub) {//0 2 4 6 8
        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int left = 0, right = data.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nub < data[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return mid + 1;
    }

    public static int findBinary2(int nub) {//0 2 4 6 8
        int[] data = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int left = 0, right = data.length - 1, mid = 0;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nub == data[mid]) {
                return mid;
            } else if (nub < data[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }
}
