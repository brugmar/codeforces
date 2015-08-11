package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR276_maximum_value {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        int n = sc.nextInt();
        int[] v = new int[n];

        int max = v[0];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            max = Math.max(max, v[i]);
        }

        int[] all = new int[max + 1];
        Arrays.fill(all, -1);

        Arrays.sort(v);
        for (int i = 0; i < n; i++) {
            if (all[v[i]] == -1) {
                all[v[i]] = i;
            }
        }

        for (int i = 1; i <= max; i++) {
            if (all[i] == -1) {
                all[i] = all[i - 1];
            }
        }

        int out = 0;
        for (int i = 2; i <= max; i++) {
            if (all[i] >= 0 && v[all[i]] == i) {
                for (int j = 2 * i; j <= max; j += i) {
                    int ind = j - 1;
                    if (all[ind] != -1 && v[all[ind]] > i) {
                        out = Math.max(out, v[all[ind]] % i);
                    }
                }
                out = Math.max(out, v[n - 1] % i);
            }
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
