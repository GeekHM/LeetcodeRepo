package LeetCode;


import org.junit.Test;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-07 14:07
 **/
public class QuickSortTest {
    @Test
    public void test() {
        int nums[] = new int[]{8, 7, 9, 11, 23, 1, 2, 6, 15, 38, 35, 3, 5, 4};
        quickSort(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int pivot = partition(nums, start, end);
        quickSort(nums, 0, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = start + (int) ((end - start) * Math.random());
        swap(nums, start, pivot);
        int left = start + 1, right = end;
        while (left < right) {
            while (left < right && nums[left] <= nums[start]) left++;
            while (left < right && nums[right] >= nums[start]) right--;
            if (left < right) swap(nums, left++, right--);
        }
        if (left == right && nums[start] < nums[right]) right--;
        swap(nums, start, right);
        return right;
    }

    public void swap(int[] data, int start, int end) {
        int temp = data[start];
        data[start] = data[end];
        data[end] = temp;
    }
}
