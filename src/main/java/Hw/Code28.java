package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-13 21:41
 **/

//描述
//输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
//本题含有多组样例输入
//
//输入描述：
//一个只包含小写英文字母和数字的字符串。
//
//输出描述：
//一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
//
//输入：
//aaddccdc
//1b1bbbbbbbbb
//输出：
//cda
//b1
//说明：
//第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
//
public class Code28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] chars = new int[128];
            char[] strs = sc.next().toCharArray();
            for (int i = 0; i < strs.length; i++) {
                chars[(int) strs[i]] += 1;
            }
            int flag = 0;
            int max = 0;
            for (int i = 0; i < strs.length; i++) {
                for (int j = 0; j < chars.length; j++) {
                    if (chars[j] > max) {
                        flag = j;
                        max = chars[j];
                    }
                }
                if (max == 0) break;
                System.out.print((char) flag);
                chars[flag] = 0;
                max = 0;
            }
            System.out.println();
        }
    }
}
