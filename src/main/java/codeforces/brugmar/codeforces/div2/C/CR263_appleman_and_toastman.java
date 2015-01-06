package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CR263_appleman_and_toastman {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[] t = new int[n];
        long s = 0;
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
            s += t[i];
        }
        
        Arrays.sort(t);
        
        long sol = (n==1)? s : 2L * s;
        for (int i = 0; i < n-2; i++) {
            s -= t[i];
            sol += s;
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