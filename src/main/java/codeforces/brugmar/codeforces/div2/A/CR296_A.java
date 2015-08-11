package codeforces.brugmar.codeforces.div2.A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR296_A {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        long a = sc.nextLong();
        long b = sc.nextLong();

        long c = 0;

        while (b != 0) {
            c += a / b;
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        
        System.out.println(c);
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
