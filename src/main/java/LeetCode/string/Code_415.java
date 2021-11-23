package LeetCode.string;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-18 22:32
 **/

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 提示：
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class Code_415 {
    public String addStrings(String num1, String num2) {
        int ov = 0, p1 = num1.length(), p2 = num2.length();
        StringBuilder res = new StringBuilder(p1 > p2 ? p1 + 1 : p2 + 1);
        int temp = 0;
        while (p1 > 0 && p2 > 0) {
            temp = num1.charAt(--p1) - '0' + num2.charAt(--p2) - '0' + ov;
            ov = temp / 10;
            res.append(temp % 10);
        }
        while (p1 > 0) {
            temp = num1.charAt(--p1) - '0' + ov;
            ov = temp / 10;
            res.append(temp % 10);
        }
        while (p2 > 0) {
            temp = num2.charAt(--p2) - '0' + ov;
            ov = temp / 10;
            res.append(temp % 10);
        }
        if (ov > 0) res.append(ov);
        return res.reverse().toString();
    }
}
