package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR255_DZY_loves_sequences {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[] v = new int[n];
        int[] l = new int[n];
        int[] r = new int[n];
        
        if (n <= 2){
            System.out.println(n);
            return;
        }

        
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }
        
        for (int i = 1; i < n; i++) {
            l[i] = v[i] > v[i-1] ? l[i-1] + 1 : 0;
        }
        
        for (int i = n-2; i >= 0; i--) {
            r[i] = v[i] < v[i+1] ? r[i+1] + 1 : 0;
        }
        
        int max = Math.max(r[1], l[n-2]) + 2;
        for (int i = 1; i < n-1; i++) {
            if (l[i] == 0 || r[i] == 0){
                int tmp = l[i-1] + 2;
                if (v[i-1] + 1 < v[i+1]){
                    tmp += r[i+1] + 1;
                } else {
                    tmp = Math.max(tmp, r[i+1] + 2);
                }
                max = Math.max(tmp, max);
            }
        }
        
        System.out.println(max);

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