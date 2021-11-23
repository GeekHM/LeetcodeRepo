package JzOffer.dynamicProgramming;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-11-09 09:55
 **/

import org.junit.Test;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * <p>
 * 输入：n = 0
 * 输出：1
 */
public class Code10_2 {
    //法一：递归
    /*public int numWays(int n) {
        if (n <= 0) return 1;
        return fbc(n);
    }

    public int fbc(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return fbc(n - 1) + fbc(n - 2);
    }*/

    //法二：动态规划
    public int numWays(int n) {
        if (n < 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            dp[i] = dp[i] % 1000000007;
        }
        return dp[n];

    }
}
