package Hw;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 10:48
 **/
//编写一个函数，计算字符串中含有的不同字符的个数。
//字符在ASCII码范围内(0~127，包括0和127)，换行表示结束符，不算在字符里。不在范围内的不作统计。多个相同的字符只计算一次
//例如，对于字符串abaca而言，有a、b、c三种不同的字符，因此输出3。
public class Code10 {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet(128);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] array = s.toCharArray();
            for (char c : array) {
                if (!bitSet.get(c)) {
                    bitSet.set(c);
                }
            }
            System.out.println(bitSet.cardinality());
        }
    }
}
