package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-09 11:05
 **/

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 给你两个数组，arr1 和 arr2，
 * arr2 中的元素各不相同
 * arr2 中的每个元素都出现在 arr1 中
 * 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 示例：
 * 输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * 输出：[2,2,2,1,4,3,3,9,6,7,19]
 */
public class Code_1122 {
//    public int[] relativeSortArray(int[] arr1, int[] arr2) {
//        int[] res = new int[arr1.length];
//        int ps = 0;
//        for (int i = 0; i < arr2.length; i++) {
//            int temp = arr2[i];
//            for (int j = 0; j < arr1.length; j++) {
//                if (arr1[j] == temp) {
//                    res[ps++] = temp;
//                }
//            }
//        }
//        Set<Integer> set = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
//    }
}
