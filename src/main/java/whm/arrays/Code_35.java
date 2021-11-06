package whm.arrays;

import org.junit.Test;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-13 10:38
 **/

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 */
public class Code_35 {
    public int searchInsert(int[] nums, int target) {
        int left=0,right=nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid]>=target){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return left;
    }

    @Test
    public void test() {
        int ps = searchInsert(new int[]{1,3,5,6},7);
        System.out.println(ps);
    }
}
