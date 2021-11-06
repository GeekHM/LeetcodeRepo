package whm.search;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-26 09:13
 **/

/**
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 * 例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组
 * [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，
 * 并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 *
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：1
 * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 *
 *
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * nums 中的所有整数 互不相同 3 3 1 3
 * nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 */
public class Code_153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    /**
     * 当上题的数据变成可以重复的时候
     * public int minArray(int[] numbers) {
     *         int left=0,right=numbers.length-1,pivot;
     *         while(left<right){
     *             pivot = left + (right-left)/2;
     *             if(numbers[pivot]<numbers[right]){
     *                 right = pivot;
     *             }else if(numbers[pivot]>numbers[right]){
     *                 left = pivot +1;
     *             } else {
     *                 right -=1;    //重点
     *             }
     *         }
     *         return numbers[left];
     *     }
     */
}
