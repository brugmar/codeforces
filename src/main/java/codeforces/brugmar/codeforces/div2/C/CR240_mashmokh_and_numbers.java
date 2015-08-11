package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR240_mashmokh_and_numbers {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int h = n / 2;

        if (k < n / 2 || (n == 1 && k != 0)) {
            System.out.println("-1");
            return;
        }

        k -= h - 1;

        if (n > 1) {
            System.out.print(k + " " + (2 * k));
        }

        int step = 0;
        int i = 1;
        while (i < h) {
            int a = i * 2 - 1 + step;
            int b = i * 2 + step;
            if (a == 2 * k || b == 2 * k || a == k || b == k) {
                step += 2;
                continue;
            }
            System.out.print(" " + a + " " + b);
            i++;
        }
        if (n % 2 == 1) {
            System.out.print(" " + 666666666);
        }
        System.out.println();
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
                while (line.isEmpty()) {
                    line = br.readLine();
                }
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
