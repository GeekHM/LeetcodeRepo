package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 14:40
 **/

import org.junit.Test;

import java.util.Arrays;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，
 * 你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 */
public class Code_215 {
    public int findKthLargest(int[] nums, int k) {
        int length = nums.length, tempk = k;
        for (int i = (length - 1) / 2; i >= 0; --i) {
            adjustHeap(nums, i, length);
        }
        for (int i = length - 1; tempk > 0; --tempk, --i) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        return nums[length - k];
    }

    public void adjustHeap(int[] nums, int parent, int length) {
        int temp = nums[parent];
        int lchild = parent * 2 + 1;
        while (lchild < length) {
            int rchild = lchild + 1;
            if (rchild < length && nums[rchild] > nums[lchild]) {
                lchild = rchild;
            }
            if (nums[lchild] <= temp) {
                break;
            }
            nums[parent] = nums[lchild];
            parent = lchild;
            lchild = lchild * 2 + 1;
        }
        nums[parent] = temp;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{3, 2, 1, 5, 6, 4};
        int k = 1;

        int length = nums.length, tempk = k;
        for (int i = (length - 1) / 2; i >= 0; --i) {
            adjustHeap(nums, i, length);
        }
        for (int i = length - 1; tempk > 0; --tempk, --i) {
            swap(nums, 0, i);
            adjustHeap(nums, 0, i);
        }
        System.out.println(Arrays.toString(nums));
    }
}
