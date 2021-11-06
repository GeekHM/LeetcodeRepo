package whm2;


import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-08 22:36
 **/
//输出7有关数字的个数，包括7的倍数，还有包含7的数字（如17，27，37...70，71，72，73...）的个数
// （一组测试用例里可能有多组数据，请注意处理）
// 输入描述：
//一个正整数N。(N不大于30000)
//
//输出描述：
//不大于N的与7有关的数字个数，例如输入20，与7有关的数字包括7,14,17.
public class Code4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt(), n2 = sc.nextInt();
        int nums1 = getNums(n1);
        int nums2 = getNums(n2);
        System.out.println(nums1);
        System.out.println(nums2);
    }

    public static int getNums(int n) {
        if (n < 7) return 0;
        int num = 0;
        for (int i = 7; i <= n; i++) {
            if (i % 7 == 0) {
                num++;
                continue;
            } else {
                int j = i;
                while (j > 0) {
                    if (j % 10 == 7) {
                        num++;
                        break;
                    } else {
                        j = j / 10;
                    }
                }
            }
        }
        return num;
    }
}