package LeetCode.stack;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-19 10:45
 **/

import org.junit.Test;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 */
public class Code_20 {
    public boolean isValid(String s) {
        /**
         * public boolean isValid(String s) {
         *         int n = s.length();
         *         if (n % 2 == 1) {
         *             return false;
         *         }
         *
         *         Map<Character, Character> pairs = new HashMap<Character, Character>() {{
         *             put(')', '(');
         *             put(']', '[');
         *             put('}', '{');
         *         }};
         *         Deque<Character> stack = new LinkedList<Character>();
         *         for (int i = 0; i < n; i++) {
         *             char ch = s.charAt(i);
         *             if (pairs.containsKey(ch)) {
         *                 if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
         *                     return false;
         *                 }
         *                 stack.pop();
         *             } else {
         *                 stack.push(ch);
         *             }
         *         }
         *         return stack.isEmpty();
         *     }
         */

        //法二：
        int length = s.length();
        char[] chars = "({[)}]".toCharArray();
        if (length % 2 != 0 || getPs(chars, s.charAt(0)) > 2) return false;
        Stack<Character> stack = new Stack<Character>();
        stack.push(s.charAt(0));
        int ps = 0;
        char temp;
        for (int i = 1; i < length ; i++) {
            ps = getPs(chars, s.charAt(i));
            if (ps < 3) {
                stack.push(s.charAt(i));
            } else {
                if(stack.empty()){
                    return false;
                }
                temp = stack.pop();
                if (getPs(chars, temp) + 3 != getPs(chars, s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public int getPs(char[] chrs, char chr) {
        for (int i = 0; i < chrs.length; i++) {
            if (chrs[i] == chr) {
                return i;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        boolean valid = isValid("(){}[][][[]]{(");
        System.out.println(valid);
    }

}
