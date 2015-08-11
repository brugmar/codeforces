package codeforces.brugmar.codeforces.div2.C;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR298_polycarpus_dice {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        long A = sc.nextLong();
        
        int[] v = new int[n];
        int lower = n-1;
        long upper = 0;
        for (int i = 0; i < n; i++) {
            upper += v[i] = sc.nextInt();
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int t = v[i];
            long left = Math.max(A - (upper-t), 1);
            long right = Math.min(A - lower, t);
            sb.append(t - (right-left+1)).append(' ');
        }
        System.out.println(sb.toString());
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