package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 22:13
 **/
//最小公倍数   a*b/最小公倍数
//最大公约数   辗转相除法   不断用 大%小 取余数
public class Code_18 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int max = in.nextInt();
        int min = in.nextInt();
        int data = getData(max, min);
        System.out.println(max * min / data);
    }

    public static int getData(int max, int min) {
        return min == 0 ? max : getData(min, max % min);
    }

}
