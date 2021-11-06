package whm3;


import java.util.Scanner;

public class Code3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int max = sc.nextInt();
            int[] nubs = new int[n];
            for (int i = 0; i < n; i++) {
                nubs[i] = sc.nextInt();
            }
            int res = 0;
            for (int i = 0; i < nubs.length; i++) {
                int sum = 0;
                for (int j = i; j < nubs.length; j++) {
                    sum += nubs[j];
                    if (sum >= max) {
                        res++;
                    }
                }
            }
            System.out.println(res);
        }
    }
}
