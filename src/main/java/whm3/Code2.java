package whm3;


import java.util.Scanner;

public class Code2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 4) System.out.println(0);
            if (n % 2 == 0) System.out.println(0);
        }
    }
}
