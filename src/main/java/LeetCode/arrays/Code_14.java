package LeetCode.arrays;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-09 08:42
 **/

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["flower","flow","flight"]
 * 输出："fl"
 * 示例 2：
 * <p>
 * 输入：strs = ["dog","racecar","car"]
 * 输出：""
 * 解释：输入不存在公共前缀。
 */
public class Code_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        int minLength = getMinLength(strs);
        StringBuilder sb = new StringBuilder();
        char temp;
        for (int i = 0; i < minLength; i++) {
            temp = strs[0].charAt(i);
            for (int j = 0; j < strs.length; j++) {
                if (temp != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(temp);
        }
        return sb.toString();
    }

    public int getMinLength(String[] strs) {
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            if (strs[i].length() < minLength) {
                minLength = strs[i].length();
            }
        }
        return minLength;
    }
}
