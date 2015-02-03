package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR259_little_pony_and_expected_maximum {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int m = sc.nextInt();
        int n = sc.nextInt();
        
        double sol = 0;
        for (int k = 1; k <= m; k++) {
            sol += (Math.pow((1d * k / m), n) - Math.pow((1D * k - 1)/m, n)) * k;
        }
        System.out.println(sol);
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