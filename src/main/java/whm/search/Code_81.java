package whm.search;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-27 22:22
 **/

/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * <p>
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * <p>
 * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 * 1 1 1 1 1 1 1 1 1 2 1 1 1 1 1
 */
public class Code_81 {//[2,5,6,0,0,1,2]

    public boolean search(int[] nums, int target) {
        int length = nums.length;
        int left = 0, right = length - 1, pivot;
        while (left < right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] > nums[right]) {
                left = pivot + 1;
            } else if (nums[pivot] < nums[right]) {
                right = pivot;
            } else {
                right--;
            }
        }
        if (nums[left] == target) return true;
        if (nums[left] > target || nums[(left - 1 + length) % length] < target) {
            return false;
        }
        if (binarySearch(nums, left, length - 1, target)) {
            return true;
        }
        if (binarySearch(nums, 0, left - 1, target)) {
            return true;
        }
        return false;
    }

    public boolean binarySearch(int[] nums, int left, int right, int target) {
        int length = nums.length, pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (nums[pivot] > target) {
                right = pivot - 1;
            } else if (nums[pivot] < target) {
                left = pivot + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
