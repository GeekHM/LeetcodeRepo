package LeetCode.search;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-26 09:31
 **/

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
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
}
