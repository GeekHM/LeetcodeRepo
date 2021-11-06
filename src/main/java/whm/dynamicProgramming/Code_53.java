package whm.dynamicProgramming;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-17 20:55
 **/

/**
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * nums = [-2,1,-3,4,-1,2,1,-5,4]
 */
public class Code_53 {
    public int maxSubArray(int[] nums) {
        int prvSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prvSum = prvSum > 0 ? prvSum + nums[i] : nums[i];
            maxSum = maxSum > prvSum ? maxSum : prvSum;
        }
        return maxSum;
    }
}
