package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR276_bits {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        for (int t = 0; t < n; t++) {
            long l = sc.nextLong();
            long r = sc.nextLong();

            long result = 0;
            for (int i = 63; i >= 0; i--) {
                if (getBit(l, i) == getBit(r, i)) {
                    result = (result << 1) | getBit(l, i);
                } else {
                    long mask = (1L << i) - 1;
                    result = ((r & mask) == mask) ? r : (result << (i + 1)) | mask;
                    break;
                }
            }
            System.out.println(result);
        }
    }

    public static int getBit(long num, int i) {
        return (int) ((num >> i) & 1);
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
