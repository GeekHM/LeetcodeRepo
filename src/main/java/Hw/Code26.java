package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-11 08:41
 **/
public class Code26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nub = sc.nextInt();
            for (int i = 2; i < (int) Math.sqrt(nub); i++) {
                if (nub % i == 0) {
                    System.out.print(i + "");
                    nub /= i;
                    i = 2;
                }
            }
            System.out.println();
        }
    }
}
