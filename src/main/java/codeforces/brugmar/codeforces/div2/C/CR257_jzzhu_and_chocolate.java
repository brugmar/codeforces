package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR257_jzzhu_and_chocolate {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        long n = sc.nextInt();
        long m = sc.nextInt();
        long k = sc.nextInt();

        if (k > n - 1 + m - 1) {
            System.out.println("-1");
            return;
        }

        k++;
        long s1 = n / k * m;
        long s2 = n * (m / k);
        long s3 = (k + 1 == m) ? 0 : n / (k + 1 - m);
        long s4 = (k + 1 == n) ? 0 : m / (k + 1 - n);
        System.out.println(max(s1, s2, s3, s4));
    }

    private static long max(long... v) {
        long max = v[0];
        for (int i = 1; i < v.length; i++) {
            max = Math.max(max, v[i]);
        }
        return max;
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
