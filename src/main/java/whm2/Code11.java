package whm2;

import org.junit.Test;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 11:14
 **/
/*
描述
1、对输入的字符串进行加解密，并输出。

2、加密方法为：

当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

其他字符不做变化。

3、解密方法为加密的逆过程。


本题含有多组样例输入。
输入描述：
输入说明
输入一串要加密的密码
输入一串加过密的密码

输出描述：
输出说明
输出加密后的字符
输出解密后的字符

输入：
abcdefg
BCDEFGH

输出：
BCDEFGH
abcdefg

 */
public class Code11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.next();
            String s2 = sc.next();
            StringBuilder encrypt = crypt(s1, 1);
            StringBuilder decrypt = crypt(s2, -1);
            System.out.println(encrypt);
            System.out.println(decrypt);
        }
    }

    public static StringBuilder crypt(String s, int flag) {
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) {
            if (c >= 'a' && c <= 'z') {
                int temp = (c - 'a' + flag) % 26;
                int r = temp >= 0 ? 'a' + temp : 'Z';
                sb.append(Character.toUpperCase((char) r));
            } else if (c >= 'A' && c <= 'Z') {
                int temp = (c - 'A' + flag) % 26;
                int r = temp >= 0 ? 'A' + temp : 'z';
                sb.append(Character.toLowerCase((char) r));
            } else {
                int temp = (c - '0' + flag) % 10;
                int r = temp >= 0 ? '0' + temp : '9';
                sb.append((char) r);
            }
        }
        return sb;
    }

    @Test
    public void test() {
        System.out.println((int) 'a' + " " + (int) 'z');
        System.out.println(-1 % 3);

    }
}
