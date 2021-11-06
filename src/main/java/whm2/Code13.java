package whm2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 14:10
 **/
//描述
//写出一个程序，接受一个十六进制的数，输出该数值的十进制表示。
//
//输入描述：
//输入一个十六进制的数值字符串。注意：一个用例会同时有多组输入数据，请参考帖子https://www.nowcoder.com/discuss/276处理多组输入的问题。
//
//输出描述：
//输出该数值的十进制字符串。不同组的测试用例用\n隔开。
//
//示例1
//输入：
//0xA
//0xAA
//输出：
//10
//170
public class Code13 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            String data = sc.next();
            Map<Character, Integer> charMap = getCharMap();
            int rs = 0, cal = 1;
            char[] chars = data.toCharArray();
            for (int i = chars.length - 1; i > 1; i--) {
                if (Character.isLetter(chars[i])) {
                    rs += cal * charMap.get(chars[i]);
                } else {
                    rs += cal * Integer.parseInt(String.valueOf(chars[i]));
                }
                cal *= 16;
            }
            System.out.println(rs);
        }
    }

    public static Map getCharMap() {
        HashMap<Character, Integer> charMap = new HashMap<>(6);
        for (int i = 0; i < 6; i++) {
            charMap.put((char) ('A' + i), 10 + i);
        }
        return charMap;
    }
}
