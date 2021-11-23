package Hw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-08 16:08
 **/

//小明身高100，班级学生1o个，身高分别为95 96 97 98 99 101 102103 104 105，
//按身高差排序后结果为: 99 101 98 10297 103 96104 95 105。

//小明身高 同学个数
//同学升高
//100 10
//95 96 97 98 99 101 102 103 104 105
public class code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int high = sc.nextInt();
        int num = sc.nextInt();
        ArrayList<Integer> list = new ArrayList<>(num + 1);
        for (int i = 0; i < num; i++) {
            list.add(sc.nextInt());
        }
        list.add(high);
        Collections.sort(list);
        int pivot = list.indexOf(high), left = pivot - 1, right = pivot + 1;
        while (left >= 0 && right <= num) {
            if (Math.abs(list.get(left) - high) <= Math.abs(list.get(right) - high)) {
                System.out.print(list.get(left--) + " ");
            } else {
                System.out.print(list.get(right++) + " ");
            }
        }
        while (left >= 0) System.out.println(list.get(left--));
        while (right <= num) System.out.println(list.get(right++));

    }
}
