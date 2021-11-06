package whm3;

import java.util.Scanner;

public class Code1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int pivot = sc.nextInt();
            String nub1 = sc.next();
            String nub2 = sc.next();
            if (!(judge(nub1) && judge(nub2))) {
                System.out.println("-1");
                continue;
            }
            int data1 = changeToDec(nub1, pivot);
            int data2 = changeToDec(nub2, pivot);
            if (data1 > data2) {
                String res = changeback(data1 - data2, pivot);
                System.out.print("0 " + res);
            } else {
                String res = changeback(data2 - data1, pivot);
                System.out.println("1 " + res);
            }
        }
    }

    public static int changeToDec(String nub, int pivot) {
        int sum = 0, temp = 1;
        for (int i = nub.length()-1; i >= 0; i--) {
            sum += toNumber(nub.charAt(i)) * temp;
            temp *= pivot;
        }
        return sum;
    }

    public static String changeback(int nub, int pivot) {
        int temp;
        StringBuilder sb = new StringBuilder();
        while (nub != 0) {
            temp = nub % pivot;
            if (temp >= 10) {
                sb.append(toChar(temp));
            } else {
                sb.append(temp);
            }
            nub /= pivot;
        }
        return sb.reverse().toString();
    }

    public static int toNumber(char str) {
        if (str >= '0' && str <= '9') {
            return str - '0';
        } else {
            return str - 'a' + 10;
        }
    }

    public static char toChar(int nub) {
        return (char) ('a' + nub - 10);
    }

    public static boolean judge(String nub) {
        if (nub.length() > 1 && nub.charAt(0) == '0') {
            return false;
        }
        return true;
    }

//    @Test
//    public void test(){
//        System.out.println(-5/30);
//    }
}
