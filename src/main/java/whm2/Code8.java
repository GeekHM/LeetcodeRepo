package whm2;

import org.junit.Test;

import java.util.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 09:19
 **/
//编写一个程序，将输入字符串中的字符按如下规则排序。
//
//规则 1 ：英文字母从 A 到 Z 排列，不区分大小写。
//
//如，输入： Type 输出： epTy
//
//规则 2 ：同一个英文字母的大小写同时存在时，按照输入顺序排列。
//
//如，输入： BabA 输出： aABb
//
//规则 3 ：非英文字母的其它字符保持原来的位置。
//
//
//如，输入： By?e 输出： Be?y

//输入：
//A Famous Saying: Much Ado About Nothing (2012/8).
//复制
//输出：
//A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).
public class Code8 {//A Famous Saying: Much Ado About Nothing

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.nextLine();
            char[] chars = s.toCharArray();
            ArrayList<Character> list = new ArrayList<>(s.length());

            for (char c : chars) {
                if (Character.isLetter(c)) {
                    list.add(c);
                }
            }

            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });

            StringBuilder sb = new StringBuilder(s.length());
            int index = 0;
            for (int i = 0; i < chars.length; i++) {
                if (Character.isLetter(chars[i])) {
                    sb.append(list.get(index++));
                } else {
                    sb.append(chars[i]);
                }
            }
            System.out.println(sb);
        }
    }
}
