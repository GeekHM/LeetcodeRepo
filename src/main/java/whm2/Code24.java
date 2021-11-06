package whm2;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-10 09:57
 **/
//描述
//•连续输入字符串，请按长度为8拆分每个输入字符串并进行输出；
//•长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
//
//输入描述：
//连续输入字符串(输入多次,每个字符串长度小于等于100)
//
//输出描述：
//依次输出所有分割后的长度为8的新字符串
//
//示例1
//输入：
//abc
//123456789
//输出：
//abc00000
//12345678
//90000000
public class Code24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int paddingNum = 8 - str.length() % 8;
            StringBuilder sb = new StringBuilder(str.length() + paddingNum);
            sb.append(str);
            for (int i = 0; i < paddingNum && paddingNum != 8; i++) {
                sb.append(0);
            }
            for (int j = 0; j < sb.length() / 8; j++) {
                System.out.println(sb.substring(j * 8, j * 8 + 8));
            }
        }
//        while (sc.hasNext()) {
//            String str = sc.next();
//            StringBuilder sb = new StringBuilder(8);
//            int length = str.length(), flag = 0;
//            while (length > 0) {
//                if (length >= 8) {
//                    System.out.println(str.substring(flag, flag + 8));
//                    length -= 8;
//                    flag += 8;
//                } else {
//                    sb.append(str, flag, flag + length);
//                    for (int i = 0; i < 8 - length; i++) {
//                        sb.append(0);
//                    }
//                    System.out.println(sb);
//                    break;
//                }
//            }
//        }
    }
}
