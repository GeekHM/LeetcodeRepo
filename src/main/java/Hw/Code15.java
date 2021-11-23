package Hw;

import java.util.Scanner;
import java.util.TreeSet;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 17:33
 **/
public class Code15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int nums = sc.nextInt();
            TreeSet<Integer> set = new TreeSet<>((o1, o2) -> o1 - o2);
            for (int i = 0; i < nums; i++) {
                set.add(sc.nextInt());
            }
            set.forEach(v-> System.out.println(v));
        }
    }
}
