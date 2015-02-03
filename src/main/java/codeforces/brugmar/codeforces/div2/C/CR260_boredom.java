package codeforces.brugmar.codeforces.div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR260_boredom {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[] c = new int[100001];
        long[] dp = new long[100001];
        
        int max = 0;
        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            c[v]++;
            max = max < v ? v : max;
        }
        
        for (int i = 0; i <= max; i++) {
            dp[i] = Math.max(1L * c[i] * i + ((i < 2) ? 0 : dp[i-2]), (i < 1) ? 0 : dp[i-1]);
        }
        
        System.out.println(dp[max]);
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