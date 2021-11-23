package Hw;

import java.util.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-10 11:10
 **/
//描述
//定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
//兄弟单词要求和原来的单词不同。例如：ab和ba是兄弟单词。ab和ab则不是兄弟单词。
//现在给定你n个单词，另外再给你一个单词str，让你寻找str的兄弟单词里，按字典序排列后的第k个单词是什么？
//注意：字典中可能有重复单词。本题含有多组输入数据。
//输入描述：
//先输入单词的个数n，再输入n个单词。 再输入一个单词，为待查找的单词x 最后输入数字k
//输出描述：
//输出查找到x的兄弟单词的个数m 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
//示例1
//输入：
//3 abc bca cab abc 1
//复制
//输出：
//2
//bca
//复制
//示例2
//输入：
//6 cab ad abcd cba abc bca abc 1
//复制
//输出：
//3
//bca
//复制
//说明：
//abc的兄弟单词有cab cba bca，所以输出3
//经字典序排列后，变为bca cab cba，所以第1个字典序兄弟单词为bca
public class Code25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int sums = sc.nextInt();
            String[] strs = new String[sums];
            for (int i = 0; i < sums; i++) {
                strs[i] = sc.next();
            }
            String pivot = sc.next();
            int p = sc.nextInt();
            List<String> resList = new ArrayList<>();
            for (int i = 0; i < strs.length; i++) {
                if (isBother(pivot, strs[i])) {
                    resList.add(strs[i]);
                }
            }
            resList.sort((o1, o2) -> o1.compareTo(o2));
            System.out.println(resList.size());
            if (resList.size() >= p) {
                System.out.println(resList.get(p - 1));
            }
        }
    }

    public static boolean isBother(String str1, String str2) {
        if (str1.length() != str2.length() || str1.equals(str2)) {
            return false;
        } else {
            char[] array1 = str1.toCharArray();
            char[] array2 = str2.toCharArray();
            Arrays.sort(array1);
            Arrays.sort(array2);
            int i = 0;
            for (i = 0; i < array1.length; i++) {
                if (array1[i] != array2[i]) {
                    break;
                }
            }
            if (i == array1.length) {
                return true;
            } else {
                return false;
            }
        }
    }
}
