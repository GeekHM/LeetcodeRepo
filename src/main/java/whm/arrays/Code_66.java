package whm.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-13 11:51
 **/

import org.junit.Test;

import java.util.Arrays;

/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 */
public class Code_66 {
    public int[] plusOne(int[] digits) {
        int length = digits.length;
        for (int i = length - 1; i >= 0; --i) {
            digits[i] = (digits[i] + 1)%10;
            if(digits[i]!=0) return digits;
        }
        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;
    }

    @Test
    public void test() {
        int[] array = plusOne(new int[]{1, 2, 3, 9});
        System.out.println(Arrays.toString(array));
    }
}
