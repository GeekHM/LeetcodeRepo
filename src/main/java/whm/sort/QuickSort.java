package whm.sort;


/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 10:52
 **/
public class QuickSort {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    private void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int mid = partition(nums, low, high);
            quickSort(nums, low, mid - 1);
            quickSort(nums, mid + 1, high);
        }
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = low + (int) (Math.random() * (high - low + 1));
        swap(nums, pivot, low);
        int i = low, j = low + 1;
        while (j <= high) {
            if (nums[j] < nums[low]) {
                swap(nums, j, ++i);
            }
            j++;
        }
        swap(nums, low, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
