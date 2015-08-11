package codeforces.brugmar.codeforces.div2.B;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR292B {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[] b = new boolean[n];
        boolean[] cb = new boolean[n];
        boolean[] g = new boolean[m];
        boolean[] cg = new boolean[m];

        int hb = sc.nextInt();
        for (int i = 0; i < hb; i++) {
            b[sc.nextInt()] = true;
        }

        int hg = sc.nextInt();
        for (int i = 0; i < hg; i++) {
            g[sc.nextInt()] = true;
        }

        int max = Math.max(b.length, g.length);

        int bInd = 0;
        int gInd = 0;
        do {
            copy(b, cb);
            copy(g, cg);

            do {
                boolean out = b[bInd] || g[gInd];
                b[bInd] = out;
                g[gInd] = out;
                bInd = (bInd + 1) % b.length;
                gInd = (gInd + 1) % g.length;
            } while(bInd != 0 || gInd != 0);
            
        } while (diff(b, cb) || diff(g, cg));

        boolean out = true;
        for (int i = 0; i < b.length; i++) {
            out &= b[i];
        }
        for (int i = 0; i < g.length; i++) {
            out &= g[i];
        }
        System.out.println(out ? "Yes" : "No");
    }

    private static void copy(boolean[] source, boolean[] dest) {
        for (int i = 0; i < source.length; i++) {
            dest[i] = source[i];
        }
    }

    private static boolean diff(boolean[] b, boolean[] cb) {
        for (int i = 0; i < b.length; i++) {
            if (b[i] != cb[i]) {
                return true;
            }
        }
        return false;
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
