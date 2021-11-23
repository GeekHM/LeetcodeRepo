package LeetCode;

import org.junit.Test;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-07 16:19
 **/
public class HeapSortTest {

    @Test
    public void test() {
        int[] arr = {16, 7, 3, 20, 17, 8};

        heapSort(arr, 3);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public void heapSort(int[] nums, int k) {
        int length = nums.length;
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjustHeap(nums, i, length);
        }

        for (int i = length - 1; i >= length - k; i--) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
    }

    public void adjustHeap(int[] nums, int parent, int length) {
        int tempData = nums[parent], lchild = parent * 2 + 1, rchild;
        while (lchild < length) {
            rchild = lchild + 1;
            if (rchild < length && nums[rchild] > nums[lchild]) {
                lchild++;
            }
            if (tempData >= nums[lchild]) break;
            nums[parent] = nums[lchild];
            parent = lchild;
            lchild = lchild * 2 + 1;
        }
        nums[parent] = tempData;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
