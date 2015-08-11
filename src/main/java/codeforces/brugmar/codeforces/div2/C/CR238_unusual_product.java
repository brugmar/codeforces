package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR238_unusual_product {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int unsqr = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int v = sc.nextInt();
                if (j == i) {
                    unsqr ^= v;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int com = sc.nextInt();
            switch (com) {
                case 1:
                case 2:
                    sc.nextInt();
                    unsqr = 1 - unsqr;
                    break;
                case 3:
                    sb.append(unsqr);
                    break;
            }
        }
        System.out.println(sb.toString());
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
