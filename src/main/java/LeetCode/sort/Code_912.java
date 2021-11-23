package LeetCode.sort;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 10:07
 **/

/**
 * 快排
 */
public class Code_912 {
    public int[] sortArray(int[] nums) {
        /** 法一： 引用类库
         *  Arrays.sort(nums);
         *  return nums;
         */

        //法二：快排

        return null;
    }

    public void quickSrot(int[] nums, int start, int end) {
        if (start >= end) return;
        int ps = partition(nums, start, end);
        quickSrot(nums, start, ps - 1);
        quickSrot(nums, ps + 1, end);
    }

    public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int left = start + 1, right = end;
        while (left < right) {
            while (left < right && nums[left] <= pivot) left++;
            while (left < right && nums[right] >= pivot) right--;
            if (left < right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }
        if (left == right && nums[left] > pivot) right--;
        swap(nums, start, right);
        return right;
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
