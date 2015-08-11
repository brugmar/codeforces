package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR290_fox_and_jumping {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        int n = sc.nextInt();
        int[] l = new int[n];
        int[] c = new int[n];

        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
        }

        int outMin = Integer.MAX_VALUE;
        int[] fact = new int[20];

        for (int i = 0; i < n; i++) {
            int factIt = 0;
            int v = l[i];
            for (int j = 2; j * j <= v; j++) {
                if (v % j == 0) {
                    fact[factIt++] = j;
                    while (v % j == 0) {
                        v /= j;
                    }
                }
            }

            if (v > 1) {
                fact[factIt++] = v;
            }

            int[] bitmsk = new int[1 << factIt];
            Arrays.fill(bitmsk, Integer.MAX_VALUE);
            bitmsk[bitmsk.length - 1] = c[i];

            for (int j = i + 1; j < n; j++) {
                int v2 = l[j];
                int msk = 0;
                for (int k = 0; k < factIt; k++) {
                    if (v2 % fact[k] == 0) {
                        msk |= 1 << k;
                    }
                }

                for (int k = 0; k < bitmsk.length; k++) {
                    if (bitmsk[k] != Integer.MAX_VALUE) {
                        bitmsk[k & msk] = Math.min(bitmsk[k & msk], bitmsk[k] + c[j]);
                    }
                }
            }
            outMin = Math.min(outMin, bitmsk[0]);
        }

        System.out.println(outMin == Integer.MAX_VALUE ? "-1" : outMin);
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
