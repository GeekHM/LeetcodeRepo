package whm.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-21 09:01
 **/

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * <p>
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * <p>
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 * <p>
 * 输入: "race a car"
 * 输出: false
 */
public class Code_125 {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (!isUse(s.charAt(i))) {
                ++i;
                continue;
            }
            if (!isUse(s.charAt(j))) {
                --j;
                continue;
            }
            if (!isEqale(s.charAt(i), s.charAt(j))) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public boolean isUse(char a) {
        return (a > 47 && a < 58) || (a > 64 && a < 91) || (a > 96 && a < 123);
    }

    public boolean isEqale(char a, char b) {
        if (a > 57 && b > 57) {
            return a == b || Math.abs(a - b) == 32;
        } else return a == b;
    }
}
