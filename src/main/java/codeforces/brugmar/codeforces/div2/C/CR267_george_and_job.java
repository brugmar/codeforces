package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CR267_george_and_job {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int k = sc.nextInt();

        int[] t = new int[n];
        long[] mSums = new long[n];
        long[][] memo = new long[n][2];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            mSums[i] = (i == 0 ? 0L : mSums[i - 1]) - (i >= m ? t[i - m] : 0) + t[i];
        }

        for (int u = 1; u <= k; u++) {
            for (int i = 0; i < n; i++) {
                memo[i][u % 2] = Math.max(i == 0 ? 0 : memo[i - 1][u % 2],
                            i + 1 < m ? 0 : (mSums[i] + ( i - m < 0 ? 0 : memo[i - m][(u + 1) % 2])));
            }
        }

        System.out.println(Math.max(memo[n - 1][0], memo[n - 1][1]));

    }

    private static void copy(PriorityQueue<Long> from, PriorityQueue<Long> to) {
        from.stream().forEach((l) -> {
            to.add(l);
        });
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
