package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR256_painting_fence {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[] f = new int[n];

        for (int i = 0; i < n; i++) {
            f[i] = sc.nextInt();
        }

        System.out.println(countStrokes(f, 0, n - 1, 0));
    }

    private static int countStrokes(int[] f, int l, int r, int h) {
        if (l > r) {
            return 0;
        }

        int minH = f[l];
        for (int i = l + 1; i <= r; i++) {
            minH = Math.min(minH, f[i]);
        }

        int sol = minH - h;

        int i = l;
        while (i <= r) {
            while (i <= r && f[i] - minH == 0) {
                i++;
            }
            int newL = i;

            while (i <= r && f[i] - minH != 0) {
                i++;
            }
            int newR = i - 1;
            sol += countStrokes(f, newL, newR, minH);
        }

        return Math.min(sol, r - l + 1);
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
