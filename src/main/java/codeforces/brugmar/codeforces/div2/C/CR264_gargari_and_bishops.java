package codeforces.brugmar.codeforces.div2.C;




import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR264_gargari_and_bishops {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        long[] dg1 = new long[2*n];
        long[] dg2 = new long[2*n];
        int[][] a = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
                dg1[i+j] += a[i][j];
                dg2[j-i+n] += a[i][j];
            }
        }
        
        long[][] sol = new long[2][3];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                long ns = dg1[i+j] + dg2[j-i+n] - a[i][j];
                int k = (i + j) % 2;
                if (ns >= sol[k][0]){
                    sol[k][0] = ns;
                    sol[k][1] = i;
                    sol[k][2] = j;
                }
            }
        }
        
        System.out.println(sol[0][0] + sol[1][0]);
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j <= 2; j++) {
                System.out.print((sol[i][j] + 1) + " ");
            }
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