package LeetCode.sort;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-24 22:49
 **/

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，
 * 输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 */
public class CodeJO_40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return arr;
        }
        heapSort(arr, k);
        int[] res = Arrays.copyOfRange(arr, arr.length - k, arr.length);
        return res;
    }

    public void heapSort(int[] arr, int k) {
        int length = arr.length;
        for (int i = (length - 1) / 2; i >= 0; --i) {
            adjustHeap(arr, i, length);
        }

        for (int i = length - 1; i >= length - k; --i) {
            swap(arr, 0, i);
            adjustHeap(arr, 0, i);
        }

    }

    public void adjustHeap(int[] arr, int parent, int length) {
        int temp = arr[parent];
        int left = parent * 2 + 1, right;
        while (left < length) {
            right = left + 1;
            if (right < length && arr[left] > arr[right]) {
                ++left;
            }
            if (temp <= arr[left]) {
                break;
            }
            arr[parent] = arr[left];
            parent = left;
            left = left * 2 + 1;
        }
        arr[parent] = temp;
    }

    public void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
