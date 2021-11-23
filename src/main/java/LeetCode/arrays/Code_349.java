package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-26 10:19
 **/

import org.junit.Test;

import java.util.HashSet;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 * <p>
 * 示例 1：
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2]
 * <p>
 * 示例 2：
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[9,4]
 *  
 * <p>
 * 说明：
 * 输出结果中的每个元素一定是唯一的。
 * 我们可以不考虑输出结果的顺序。
 */
public class Code_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();
        HashSet<Integer> resSet = new HashSet<Integer>();

        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resSet.add(i);
            }
        }
        int[] res = resSet.stream().mapToInt(Number::intValue).toArray();
        return res;
    }

    @Test
    public void test() {
        intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2});
    }
}
