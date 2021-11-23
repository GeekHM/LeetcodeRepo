package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-12 22:36
 **/

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

/**
给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出
和为目标值 的那 两个 整数，并返回它们的数组下标。
 */

public class Code_1 {
    public int[] twoSum(int[] nums, int target) {
        //法一:
        /**
         * for(int i=0;i<nums.length;i++){
         *             for(int j=1;j<nums.length;j++){
         *                 if(nums[i]+nums[j]==target){
         *                     return new int[]{i,j};
         *                 }
         *             }
         *         }
         *         return null;
         */
        //法二：
        HashMap<Integer,Integer> hashMap = new HashMap();
        int length = nums.length;
        for (int i = 0; i < length; i++) {
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{i,hashMap.get(target - nums[i])};
            }
            hashMap.put(nums[i],i);
        }
        return null;
    }

    @Test
    public void test() {
        int[] indexs = twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(indexs));
    }
}
