package LeetCode.string;

import org.junit.Test;

/**
 * @description
 * @author: wanghaoming
 * @create: 2020-11-04 19:49
 **/

//给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?'
// 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。
public class Code_1756 {
    public String code(String s) {
        char[] chars = s.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '?') {
                //前面一个字符  如果当前是第0个的话 字符就为‘ ’
                char ahead = i == 0 ? ' ' : chars[i - 1];
                //后面一个字符  如果当前是最后一个的话 字符就为‘ ’
                char behind = i == chars.length - 1 ? ' ' : chars[i + 1];
                //从a开始比较  如果等于前面或者后面的话 就+1
                char temp = 'a';
                while (temp == ahead || temp == behind) {
                    temp++;
                }
                //找到目标字符后 做替换
                chars[i] = temp;
            }
        }
        return new String(chars);
    }

    @Test
    public void test() {
        code("??");
    }
}