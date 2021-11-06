package whm2;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 18:21
 **/
//描述
//给定一个仅包含小写字母的字符串，求它的最长回文子串的长度。
//所谓回文串，指左右对称的字符串。
//所谓子串，指一个字符串删掉其部分前缀和后缀（也可以不删）的字符串
//（注意：记得加上while处理多个测试用例）
//
//输入描述：
//输入一个仅包含小写字母的字符串
//
//输出描述：
//返回最长回文子串的长度
//
//示例1
//输入：
//cdabbacc
//输出：
//4
//说明：
//abba为最长的回文子串
public class Code_17 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int max = 0;
        /**
         *双指针遍历找到最长子串
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length(); j > i; j--) {
                String toBeJuged = s.substring(i, j);
                if (isPalindromeString(toBeJuged)) {
                    max = Math.max(max, j - i);
                }
            }
        }
        System.out.print(max);
    }

    /**
     * 判断一个字符串是否是回文字符串的方法
     */
    static boolean isPalindromeString(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }
}
