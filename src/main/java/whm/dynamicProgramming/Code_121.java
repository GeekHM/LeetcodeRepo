package whm.dynamicProgramming;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-05-20 11:30
 **/

/**
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * <p>
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 */
public class Code_121 {
    public int maxProfit(int[] prices) {
        /**
         * 法一：
         *         int length = prices.length;
         *         if (length < 2) return 0;
         *         int max = 0, money = 0;
         *         for (int buyDay = 0; buyDay < length; ++buyDay) {
         *             for (int sellDay = buyDay + 1; sellDay < length; ++sellDay) {
         *                 money = prices[sellDay] - prices[buyDay];
         *                 max = money > max ? money : max;
         *             }
         *         }
         *         return max;
         */
        //法二：
        int minPrice = Integer.MAX_VALUE, maxMoney = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) {
                minPrice = prices[i];
            } else {
                maxMoney = maxMoney > prices[i] - minPrice ? maxMoney : prices[i] - minPrice;
            }
        }
        return maxMoney;
    }
}
