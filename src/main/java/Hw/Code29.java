package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-13 23:15
 **/
//密码按如下规则进行计分，并根据不同的得分为密码进行安全等级划分。
//
//一、密码长度:
//
//5 分: 小于等于4 个字符
//
//10 分: 5 到7 字符
//
//25 分: 大于等于8 个字符
//
//二、字母:
//
//0 分: 没有字母
//
//10 分: 全都是小（大）写字母
//
//20 分: 大小写混合字母
//
//三、数字:
//
//0 分: 没有数字
//
//10 分: 1 个数字
//
//20 分: 大于1 个数字
//
//四、符号:
//
//0 分: 没有符号
//
//10 分: 1 个符号
//
//25 分: 大于1 个符号
//
//五、奖励:
//
//2 分: 字母和数字
//
//3 分: 字母、数字和符号
//
//5 分: 大小写字母、数字和符号
//
//最后的评分标准:
//
//>= 90: 非常安全
//
//>= 80: 安全（Secure）
//
//>= 70: 非常强
//
//>= 60: 强（Strong）
//
//>= 50: 一般（Average）
//
//>= 25: 弱（Weak）
//
//>= 0:  非常弱
//
//
//对应输出为：
//
//VERY_SECURE
//
//SECURE
//
//VERY_STRONG
//
//STRONG
//
//AVERAGE
//
//WEAK
//
//VERY_WEAK
//
//
//请根据输入的密码字符串，进行安全评定。
//
//注：
//
//字母：a-z, A-Z
//
//数字：0-9
//
//符号包含如下： (ASCII码表可以在UltraEdit的菜单view->ASCII Table查看)
//
//!"#$%&'()*+,-./     (ASCII码：0x21~0x2F)
//
//:;<=>?@             (ASCII码：0x3A~0x40)
//
//[\]^_`              (ASCII码：0x5B~0x60)
//
//{|}~                (ASCII码：0x7B~0x7E)
//
//
//
//提示:
//1 <= 字符串的长度<= 300
//输入描述：
//本题含有多组输入样例。
//每组样例输入一个string的密码
//
//输出描述：
//每组样例输出密码等级
//
//示例1
//输入：
//38$@NoNoNo
//123
//输出：
//VERY_SECURE
//WEAK
//说明：
//第一组样例密码强度为95分。
//第二组样例密码强度为25分。
public class Code29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int score = 0, digits = 0, upperCase = 0, lowerCase = 0, chars = 0;
            for (int i = 0; i < str.length(); i++) {
                if (Character.isDigit(str.charAt(i))) {
                    digits++;
                } else if (Character.isUpperCase(str.charAt(i))) {
                    upperCase++;
                } else if (Character.isLowerCase(str.charAt(i))) {
                    lowerCase++;
                } else if (is_symbol(str.charAt(i))) {
                    chars++;
                }
            }
            if (str.length() > 8) {
                score += 25;
            } else if (str.length() > 5) {
                score += 10;
            } else {
                score += 5;
            }
            if (upperCase > 0 && lowerCase > 0) {
                score += 20;
            } else if (upperCase > 0 || lowerCase > 0) {
                score += 10;
            }
            if (digits > 1) {
                score += 20;
            } else if (digits == 1) {
                score += 10;
            }
            if (chars > 1) {
                score += 25;
            } else if (chars == 1) {
                score += 10;
            }
            if (upperCase != 0 && lowerCase != 0 && chars > 0 && digits > 0) {
                score += 5;
            } else if ((upperCase > 0 || lowerCase > 0) && digits >= 0 && chars > 0) {
                score += 3;
            } else if ((upperCase > 0 || lowerCase > 0) && digits >= 0) {
                score += 2;
            }
            print(score);
        }
    }

    public static void print(int score) {
        if (score >= 90) {
            System.out.println("VERY_SECURE");
        } else if (score >= 80) {
            System.out.println("SECURE");
        } else if (score >= 70) {
            System.out.println("VERY_STRONG");
        } else if (score >= 60) {
            System.out.println("STRONG");
        } else if (score >= 50) {
            System.out.println("AVERAGE");
        } else if (score >= 25) {
            System.out.println("WEAK");
        } else {
            System.out.println("VERY_WEAK");
        }
    }

    public static boolean is_symbol(char c) {
        if ((int) c >= '!' && (int) c <= '/') {
            return true;
        } else if ((int) c >= ':' && (int) c <= '@') {
            return true;
        } else if ((int) c >= '[' && (int) c <= '`') {
            return true;
        } else if ((int) c >= '{' && (int) c <= '~') {
            return true;
        } else {
            return false;
        }
    }
}
