package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR273_red_green_towers {

    private static final int M = 1000000007;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        int r = sc.nextInt();
        int g = sc.nextInt();

        long sum = 0L + r + g;

        int h = (int) Math.sqrt(sum * 2);
        if (1L * h * (h + 1) / 2 > sum) {
            h--;
        }

        if (r > g) {
            r = r ^ g;
            g = r ^ g;
            r = r ^ g;
        }

        int[] dp = new int[r + 2];

        dp[0] = 1;
        dp[1] = 1;

        for (int ch = 2; ch <= h; ch++) {
            int size = (int) (1L * ch * (ch + 1) / 2);
            for (int cr = Math.min(r, size); cr >= 0 ; cr--) {
                int cg = size - cr;
                int tmp = 0;
                if (cr >= ch) {
                    tmp = (tmp + dp[cr - ch]) % M;
                }
                if (cg >= ch) {
                    tmp = (tmp + dp[cr]) % M;
                }
                dp[cr] = tmp;
            }
        }

        int stackSize = (int) (1L * h * (h + 1) / 2);
        int left = (int) (sum - stackSize);
        long out = 0;
        for (int i = 0; i <= Math.min(left, r); i++) {
            out = (out + dp[r - i]) % M;
        }
        System.out.println(out);
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
