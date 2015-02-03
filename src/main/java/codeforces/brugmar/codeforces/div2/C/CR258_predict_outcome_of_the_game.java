package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR258_predict_outcome_of_the_game {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();

        _nextTestCase:
        for (int tt = 0; tt < t; tt++) {
            long n = sc.nextLong();
            long pc = sc.nextLong();
            long w1 = sc.nextLong();
            long w2 = sc.nextLong();

            long r = n - pc;

            long[] k1Tab = {w1, -w1};
            long[] k2Tab = {w2, -w2};

            for (long k1 : k1Tab) {
                for (long k2 : k2Tab) {
                    long b = r - k1 + k2;
                    if (b % 3 != 0) continue;
                    b /= 3;
                    long a = k1 + b;
                    long c = b - k2;
                    if (a >= 0 && b >= 0 && c >= 0) {
                        long t2 = pc + a - 2 * b + c;
                        if (t2 % 3 != 0) continue;
                        t2 /= 3;
                        long t1 = -a + b + t2;
                        long t3 = t2 + b - c;
                        if (t1 >=0 && t2 >= 0 && t3 >= 0){
                            System.out.println("yes");
                            continue _nextTestCase;
                        }
                    }
                }
            }
            System.out.println("no");
        }

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
