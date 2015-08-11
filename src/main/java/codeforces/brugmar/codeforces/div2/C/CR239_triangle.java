package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR239_triangle {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        int a = sc.nextInt();
        int b = sc.nextInt();

        int min = Math.min(a, b);
        int max = Math.max(a, b);

        long minSqr = 1L * min * min;
        long maxSqr = 1L * max * max;
        for (long y = 1; y < min; y++) {
            long x = Math.round(Math.sqrt(minSqr - y * y));
            if (x > 0 && y * y + x * x == minSqr) {
                long lx = -y;
                long ly = x;
                double s = 1D * max / min;
                lx = Math.round(1D * lx * s);
                ly = Math.round(1D * ly * s);
                if (lx * lx + ly * ly == maxSqr) {
                    System.out.println("YES");
                    System.out.println("0 0");
                    System.out.println(x + " " + y);
                    System.out.println(lx + " " + ly);
                    return;
                }
            }
        }

        System.out.println("NO");
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
