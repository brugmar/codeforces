package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR281_vasya_and_basketball {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int an = sc.nextInt();
        int[] at = new int[an];
        for (int i = 0; i < an; i++) {
            at[i] = sc.nextInt();
        }
        int bn = sc.nextInt();
        int[] bt = new int[bn];
        for (int i = 0; i < bn; i++) {
            bt[i] = sc.nextInt();
        }
        Arrays.sort(at);
        Arrays.sort(bt);

        int pa = 0;
        int pb = 0;

        long maxA = 3L * an;
        long maxB = 3L * bn;
        long maxdiff = maxA - maxB;

        while (pa < an || pb < bn) {
            int min = Math.min((pa == an) ? Integer.MAX_VALUE : at[pa],
                    (pb == bn) ? Integer.MAX_VALUE : bt[pb]);
            while (pa < an && at[pa] == min) {
                pa++;
            }
            while (pb < bn && bt[pb] == min) {
                pb++;
            }
            long newA = 2L * pa + 3L * (an - pa);
            long newB = 2L * pb + 3L * (bn - pb);
            long newDiff = newA - newB;
            if (newDiff > maxdiff || (newDiff == maxdiff && newA > maxA)) {
                maxA = newA;
                maxB = newB;
                maxdiff = newDiff;
            }
        }

        System.out.println(maxA + ":" + maxB);
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
