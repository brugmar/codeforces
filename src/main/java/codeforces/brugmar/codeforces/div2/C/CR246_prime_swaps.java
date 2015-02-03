package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR246_prime_swaps {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int PL = 500011;
        boolean[] p = new boolean[PL];

        for (int i = 0; i < PL; i++) {
            p[i] = true;
        }
        for (int i = 2; i < PL; i++) {
            for (int j = 2 * i; j < PL; j += i) {
                p[j] = false;
            }
        }

        int n = sc.nextInt();
        Pair[] v = new Pair[n];
        Pair[] sv = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            v[i] = new Pair(sc.nextInt(), i);
            sv[i] = v[i];
        }
        
        Arrays.sort(sv, (a, b) -> (a.v == b.v)? a.ind - b.ind : a.v - b.v);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            Pair l = sv[i];
            while (l.ind != i){
                int range = l.ind - i + 1;
                while (!p[range]){
                    range--;
                }
                int oldInd = l.ind;
                int newInd = l.ind - range + 1;
                
                Pair tmp = v[newInd];
                v[newInd] = l;
                v[oldInd] = tmp;
                
                v[oldInd].ind = oldInd;
                v[newInd].ind = newInd;
                
                sb.append(newInd+1).append(' ').append(oldInd+1).append('\n');
                count++;
            }
        }
        
        System.out.println(count);
        System.out.println(sb.toString());
    }
    
    static class Pair {
        int v;
        int ind;

        public Pair(int v, int ind) {
            this.v = v;
            this.ind = ind;
        }
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
