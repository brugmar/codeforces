package codeforces.brugmar.codeforces.div2.B;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR_252_B {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        
        int n = sc.nextInt();
        int v = sc.nextInt();
        
        int[] days = new int[3002];
        
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int nb = sc.nextInt();
            days[d] += nb;
        }
        
        int out = 0;
        for (int i = 1; i < 3002; i++) {
            int workLeft = v;
            int first = Math.min(workLeft, days[i-1]);
            out += first;
            workLeft -= first;
            int sec = Math.min(workLeft, days[i]);
            out += sec;
            days[i] -= sec;
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