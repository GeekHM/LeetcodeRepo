package LeetCode.sort;

import org.junit.Test;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 11:18
 **/
public class QuickSort2 {
    @Test
    public void test() {
        int nums[] = new int[]{8, 7, 9, 11, 23, 1, 2, 6, 15, 38, 35, 3, 5, 4};
        sortArray(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    //递归快排
    public void quickSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = partition(nums, start, end);
        quickSort(nums, start, mid - 1);
        quickSort(nums, mid + 1, end);
    }

    //根据基数划分新的区域
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1, right = end;
        while (left < right) {
            //从左找到第一个比基数大的数
            while (left < right && nums[left] <= pivot) left++;
            //从右找到第一个比基数小的数
            while (left < right && nums[right] >= pivot) right--;
            //交换位置
            if (left < right) {
                exchange(nums, left, right);
                left++;
                right--;
            }
        }//2 1 5 9 4 3     1 2 5 9 4 3
        //5  9  4  3    5 3 4 9   4 3 5 9
        /*这样也是可以的（只从左找第一个比基数大的数，与最后一个位置交换）*/
        // while(left < right){
        //     while(left < right && nums[left] <= pivot) left++;
        //     if(left != right){
        //         exchange(nums, left, right);
        //         right--;
        //     }
        // }
        if (left == right && nums[right] > pivot) right--;
        exchange(nums, start, right);
        return right;
    }

    //交换数组中的两个元素（注意exchage(nums[left], nums[right])是不行的）
    //java中基本数据类型是值传递
    public void exchange(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
