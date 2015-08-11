package codeforces.brugmar.codeforces.div2.C;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR242_magic_formulas {
    
    private static int[] xor;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        xor = new int[n];
        int out = 0;
        for (int i = 0; i < n; i++) {
            out ^= sc.nextInt();
        }
        
        for (int i = 1; i < n; i++) {
            xor[i] = i ^ xor[i-1];
        }
        
        for (int i = 2; i <= n; i++) {
            int d = n / i;
            out ^= (d % 2 == 0) ? 0 : xor[i-1];
            int r = n % i;
            out ^= xor[r];
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
                while (line.isEmpty()){
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