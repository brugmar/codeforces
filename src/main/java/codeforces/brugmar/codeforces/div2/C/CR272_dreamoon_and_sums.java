package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR272_dreamoon_and_sums {

    public static void main(String... args) throws IOException {
        final int M = 1000000007;
        MyScanner sc = new MyScanner();
        long a = sc.nextInt();
        long b = sc.nextInt();
        
        long sumb = (((b-1)*b)/2) % M;
        long suma = (((a+1)*a)/2) % M;
        long result = (a + b*suma) % M;
        result = (result * sumb) % M;
        System.out.println(result);
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