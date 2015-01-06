package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR268_24_game {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        if (n < 4) {
            System.out.println("NO");
            return;
        }
        System.out.println("YES");
        if (n == 4) {
            System.out.println("1 * 2 = 2");
            System.out.println("2 * 3 = 6");
            System.out.println("6 * 4 = 24");
            return;
        }

        if (n == 5) {
            System.out.println("3 - 1 = 2");
            System.out.println("2 + 2 = 4");
            System.out.println("4 * 5 = 20");
            System.out.println("20 + 4 = 24");
            return;
        }

        System.out.println("2 * 3 = 6");
        System.out.println("6 * 4 = 24");
        System.out.println("6 - 1 = 5");
        System.out.println("5 - 5 = 0");

        if (n > 6) {
            long sum = 7;
            for (int i = 8; i <= n; i++) {
                long tmp = sum + i;
                System.out.println(sum + " + " + i + " = " + tmp);
                sum = tmp;
            }
            System.out.println(sum + " * 0 = 0");
        }
        System.out.println("0 + 24 = 24");
    }

    static class MyScanner {

        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public String next() throws IOException {
            if (st == null || !st.hasMoreTokens()) {
                String line = br.readLine();
                st = new StringTokenizer(line);
            }
            return st.nextToken();
        }

        public int nextInt() throws IOException {
            String next = next();
            return Integer.parseInt(next);
        }

        private long nextLong() throws IOException {
            String next = next();
            return Long.parseLong(next);
        }
    }
}
