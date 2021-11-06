package whm2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-09 23:26
 **/
//描述
//从输入任意个整型数，统计其中的负数个数并求所有非负数的平均值，结果保留一位小数，如果没有非负数，则平均值为0
//本题有多组输入数据，输入到文件末尾，请使用while(cin>>)读入
//数据范围小于1e6
//输入描述：
//输入任意个整数，每行输入一个。
//
//输出描述：
//输出负数个数以及所有非负数的平均值
public class Code19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double sum = 0;
        int ps = 0, ng = 0;
        while (sc.hasNext()) {
            double v = sc.nextDouble();
            if (v < 0) {
                ps++;
            } else {
                sum += v;
                ng++;
            }
        }
        System.out.println(ps);
        System.out.println(ng == 0 ? 0.0 : new DecimalFormat("0.0").format(sum / ng));
    }
}
