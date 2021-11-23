package Hw;

import java.util.Scanner;

/**
 * @description
 * @author: wanghaoming
 * @create: 2021-10-10 07:31
 **/
public class Code23 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            if (str.contains(".")) {
                ipToNub(str);
            } else {
                nubToIp(Long.parseLong(str));
            }
        }
    }

    public static void ipToNub(String str) {
        String[] ips = str.split("\\.");
        long sum = 0;
        int cal = 1;
        for (int i = ips.length - 1; i >= 0; i--) {
            sum += Long.parseLong(ips[i]) * cal;
            cal *= 256;
        }
        System.out.println(sum);
    }

    public static void nubToIp(Long nub) {
        Long ipTemp;
        StringBuilder ip = new StringBuilder();
        while (nub > 0) {
            ipTemp = nub % 256;
            nub /= 256;
            if (ip.length() == 0) {
                ip.append(ipTemp);
            } else {
                ip = new StringBuilder().append(ipTemp + ".").append(ip);
            }
        }
        System.out.println(ip);
    }
}
