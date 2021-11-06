package whm2;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 17:15
 **/
//描述
//写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
//
//输入描述：
//第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
//
//输出描述：
//输出输入字符串中含有该字符的个数。
//
//示例1
//输入：
//ABCabc
//A

//输出：
//2
public class Code14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char c = sc.next().toLowerCase().toCharArray()[0];
            char[] chars = str.toCharArray();
            int num = 0;
            for (char aChar : chars) {
                if (Character.toLowerCase(aChar) == c) {
                    num++;
                }
            }
            System.out.println(num);
        }
    }
}
