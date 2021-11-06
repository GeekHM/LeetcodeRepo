package whm.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-23 16:55
 **/

import java.util.HashSet;

/**
 * 找出数组中重复的数字。
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 *
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 */
public class CodeOffer_03 {
    public int findRepeatNumber(int[] nums) {
        /**
         * 法一：
         * HashSet<Integer> set = new HashSet<Integer>();
         *         for (int i = 0; i < nums.length; i++) {
         *             if(set.contains(nums[i])){
         *                 return nums[i];
         *             }
         *             set.add(nums[i]);
         *         }
         *         return -1;
         */

        //法二：
        int i = 0;
        int tmp;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]) return nums[i];
            tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }
}
