package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class CRGB2004_new_year_book_reading {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] w = new int[n];
        
        for (int i = 0; i < n; i++) {
            w[i] = sc.nextInt();
        }
        
        int[] d = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = sc.nextInt()-1;
        }
        
        boolean[] usedBooks = new boolean[n];
        
        ArrayDeque<Integer> s = new ArrayDeque<>(n);
        for (int i = 0; i < m; i++) {
            if (!usedBooks[d[i]]){
                usedBooks[d[i]] = true;
                s.addLast(d[i]); 
            }
        }
        
        long sol = 0;
        for (int i = 1; i < m; i++) {
            ArrayDeque<Integer> tmp = new ArrayDeque<>();
            while (s.peek() != d[i]){
                int v = s.pop();
                sol += w[v];
                tmp.push(v);
            }
            
            int acc = s.pop();
            while (!tmp.isEmpty()){
                s.push(tmp.pop());
            }
            s.push(acc);
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