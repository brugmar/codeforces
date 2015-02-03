package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR249_cardiogram {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int v[] = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int min = 0;
        int max = v[0];

        int card = 0;
        int w = 0;
        for (int i = 0; i < n; i++) {
            card += (i % 2 == 0) ? v[i] : -v[i];
            w += v[i];
            min = Math.min(min, card);
            max = Math.max(max, card);
        }

        int h = max - min;
        StringBuilder[] sbs = new StringBuilder[h];
        for (int i = 0; i < h; i++) {
            sbs[i] = new StringBuilder(w);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int step = (i % 2 == 0) ? 1 : -1;
            for (int j = 0; j < v[i]; j++) {
                for (int k = 0; k < h; k++) {
                    if (sum - min == k) {
                        sbs[k].append((step == 1) ? '/' : '\\');
                    } else {
                        sbs[k].append(' ');
                    }
                }
                sum += step;
            }
            sum += -1 * step;
        }

        for (int i = h - 1; i >= 0; i--) {
            System.out.println(sbs[i].toString());
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
