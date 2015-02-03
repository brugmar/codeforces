package codeforces.brugmar.codeforces.div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR247_k_tree {
    
    private static final int M = 1000000007;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int d = sc.nextInt();
        
        int[] all = new int[n+1];
        int[] atLeast = new int[n+1];
        
        all[0] = 1;
        atLeast[0] = 0;
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= Math.min(i, k); j++) {
                all[i] = (all[i] + all[i-j]) % M;
            }
            for (int j = 1; j <= Math.min(i, k); j++) {
                if (i == j){
                    atLeast[i] += (j >= d) ? 1 : 0;
                }
                else if (j >= d){
                    atLeast[i] = (atLeast[i] + all[i-j]) % M;
                } else {
                    atLeast[i] = (atLeast[i] + atLeast[i-j]) % M;
                }
            }
        }

        System.out.println(atLeast[n]);
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