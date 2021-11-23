package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-10 00:15
 **/
//斐波那契
public class Code21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int num = sc.nextInt();
            int m1 = 1, m2 = 1, rs = 0;
            if (num == 1 || num == 2) {
                System.out.println(1);
                return;
            }
            for (int i = 2; i < num; i++) {
                rs = m1 + m2;
                m1 = m2;
                m2 = rs;
            }
            System.out.println(rs);
        }
    }
}
