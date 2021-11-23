package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-13 11:11
 **/

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 *给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 */
public class Code_39 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        return new LinkedList<List<Integer>>();
    }

    @Test
    public void test() {
        combinationSum(new int[]{2,3,6,7}, 7);

    }
}
