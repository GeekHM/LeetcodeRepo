package whm2;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 17:49
 **/
//描述
//根据输入的日期，计算是这一年的第几天。
//
//
//输入描述：
//输入一行，每行空格分割，分别是年，月，日
//
//输出描述：
//输出是这一年的第几天
//示例1
//输入：
//2012 12 31
//输出：
//366
//示例2
//输入：
//1982 3 4
//输出：
//63
public class Code16 {
    public static final int[] DATE_TABLE = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] dates = str.split(" ");
            int year = Integer.parseInt(dates[0]),
                    mouth = Integer.parseInt(dates[1]),
                    day = Integer.parseInt(dates[2]);
            int days = getDays(mouth, day);
            if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0 && mouth > 2) {
                days++;
            }
            System.out.println(days);
        }
    }

    public static int getDays(int mouth, int day) {
        int days = 0;
        for (int i = 1; i <= mouth; i++) {
            days += DATE_TABLE[i - 1];
        }
        return days;
    }
}
