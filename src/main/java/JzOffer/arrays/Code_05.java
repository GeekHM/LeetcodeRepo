package JzOffer.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-09 08:34
 **/

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 */
public class Code_05 {
    public String replaceSpace(String s) {
        //法一
        String s1 = s.replace(" ", "%20");
        //法二
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                sb.append(s.charAt(i));
            } else {
                sb.append("%20");
            }
        }
        return s;
    }
}
