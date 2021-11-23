package LeetCode.arrays;

import org.junit.Test;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-13 09:32
 **/

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class Code_27 {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        int left= 0;
        for (int right = 0; right < length; ++right) {
            if(nums[right]!=val){
                nums[left++] = nums[right];
            }
        }
        return left;
    }

    @Test
    public void test() {
        int length = removeElement(new int[]{0,1,2,2,3,0,4,2},2);
        System.out.println(length);
    }
}
