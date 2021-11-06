package whm.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-13 09:12
 **/

import org.junit.Test;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class Code_26 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if(length<=1) return length;
        int ps=0;
        for (int i = 1; i < length; ++i) {
            if(nums[ps]!=nums[i]){
                nums[++ps] = nums[i];
            }
        }
        return ps+1;
    }

    @Test
    public void test() {
        int length = removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});
        System.out.println(length);
    }
}
