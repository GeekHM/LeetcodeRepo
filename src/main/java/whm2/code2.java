package whm2;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-08 16:49
 **/

//拼接url，给定一个字符串，中间存在“，”隔开前后两个url，
//要求拼接这两个url，且中间有且只有一个“/”。 （例如 abc/,/bdd 输出abc/bdd）
public class code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = sc.next();
        String[] split = url.split(",/");
        StringBuilder sb = new StringBuilder(url.length());
        for (String s : split) {
            sb.append(s);
        }
        System.out.println(sb);
    }
}
