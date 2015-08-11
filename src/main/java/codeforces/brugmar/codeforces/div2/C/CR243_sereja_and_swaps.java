package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR243_sereja_and_swaps {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] v = new int[n];
        Pair[] cp = new Pair[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            cp[i] = new Pair(v[i], i);
        }

        Arrays.sort(cp, (a, b) -> a.v - b.v);

        int maxSum = v[0];

        int[] sums = new int[n];
        for (int i = 0; i < n; i++) {
            sums[i] = v[i] + ((i == 0) ? 0 : sums[i - 1]);
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = sums[j] - ((i == 0) ? 0 : sums[i - 1]);
                int ind = n - 1;
                int[] tmpTab = new int[j - i + 1];
                for (int m = i; m <= j; m++) {
                    tmpTab[m - i] = v[m];
                }
                Arrays.sort(tmpTab);

                int kCount = 0;
                while (kCount < Math.min(k, tmpTab.length) && ind >= 0) {
                    while (ind >= 0 && cp[ind].i >= i && cp[ind].i <= j) {
                        ind--;
                    }
                    if (ind >= 0) {
                        if (cp[ind].v < tmpTab[kCount]) {
                            ind = -1;
                        } else {
                            sum -= tmpTab[kCount];
                            sum += cp[ind].v;
                            ind--;
                            kCount++;
                        }
                    }
                }
                if (sum > maxSum) {
                    maxSum = sum;
                }
            }
        }

        System.out.println(maxSum);
    }

    private static class Pair {

        int v;
        int i;

        public Pair(int v, int i) {
            this.v = v;
            this.i = i;
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
