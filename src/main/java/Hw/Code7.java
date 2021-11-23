package Hw;

import org.junit.Test;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 09:02
 **/
//输入一个整数，将这个整数以字符串的形式逆序输出
//程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
public class Code7 {
    public static void main(String[] args) {
        //法一：
//        Scanner sc = new Scanner(System.in);
//        int nub = sc.nextInt();
//        if (nub == 0) System.out.println("0");
//        while (nub > 0) {
//            System.out.print(nub % 10);
//            nub /= 10;
//        }
//        System.out.println();

        //法二：
        Scanner sc = new Scanner(System.in);
        String rs = sc.next();
        StringBuilder sb = new StringBuilder(rs);
        System.out.println(sb.reverse());
    }

    @Test
    public void test() {//练习下字符串
        String s = new String("aa sss");
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if(c!=' '){
                System.out.print(c);
            }
        }
    }
}
