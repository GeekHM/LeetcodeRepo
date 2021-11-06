package whm.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-20 19:56
 **/

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -104 <= nums[i] <= 104
 * nums 已按升序排列
 */
public class Code_80 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length, ps = 0, eq = 0;
        for (int i = 1; i < length; i++) {
            if (nums[ps] == nums[i]) {
                if (eq <1) {
                    nums[++ps] = nums[i];
                    eq++;
                }
            } else {
                eq = 0;
                nums[++ps] = nums[i];
            }
        }
        return ps + 1;
    }
}
