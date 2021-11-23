package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 10:23
 **/
/*1 15 30 45 51
1 46 90

3 2
4 3
5 2
6 4
7 2
 */
public class Code9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int i = sc.nextInt();
            if (i == 1 || i == 2) {
                System.out.println(-1);
                continue;
            } else if (i % 2 == 0) {
                System.out.println(0);
            }else if (i % 3 == 0) {
                System.out.println(2);
            }else if (i % 4 == 0) {
                System.out.println(2);
            }
        }
    }
}
