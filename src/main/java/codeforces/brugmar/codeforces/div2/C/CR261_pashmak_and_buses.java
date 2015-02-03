package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR261_pashmak_and_buses {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();

        if (Math.pow(k, d) < n) {
            System.out.println("-1");
            return;
        }
        long step = 1;
        for (int i = 0; i < d; i++) {
            int v = 0;
            int c = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(v + 1).append(' ');
                c++;
                if (c == step) {
                    v = (v + 1) % k;
                    c = 0;
                }
            }
            System.out.println(sb.toString());
            step = Math.min(n+1, step * k);
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
