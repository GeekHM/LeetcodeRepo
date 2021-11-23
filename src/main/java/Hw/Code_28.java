package Hw;


import java.util.*;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-11 12:38
 **/

//描述
//输入一个只包含小写英文字母和数字的字符串，按照不同字符统计个数由多到少输出统计结果，如果统计的个数相同，则按照ASCII码由小到大排序输出。
//本题含有多组样例输入
//
//输入描述：
//一个只包含小写英文字母和数字的字符串。
//
//输出描述：
//一个字符串，为不同字母出现次数的降序表示。若出现次数相同，则按ASCII码的升序输出。
//
//示例1
//输入：
//aaddccdc
//1b1bbbbbbbbb
//输出：
//cda
//b1
//说明：
//第一个样例里，c和d出现3次，a出现2次，但c的ASCII码比d小，所以先输出c，再输出d，最后输出a.
public class Code_28 {
    static class Node implements Comparator<Node> {
        private String c;
        private int nums;

        public Node(String c, int nums) {
            this.c = c;
            this.nums = nums;
        }

        @Override
        public int compare(Node o1, Node o2) {
            if (o1.nums != o2.nums) {
                return o2.nums - o1.nums;
            } else {
                return o1.c.compareTo(o2.c);
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return node.c.equals(this.c);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Node> set = new TreeSet<>();
        while (sc.hasNext()) {
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {

            }
        }
    }
}
