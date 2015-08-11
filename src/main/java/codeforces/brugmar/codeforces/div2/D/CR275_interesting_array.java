package codeforces.brugmar.codeforces.div2.D;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR275_interesting_array {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] from = new int[m];
        int[] to = new int[m];
        int[] eq = new int[m];
        
        int[][] v = new int[n+1][30];
        int[][] sums = new int[n][30];
        
        for (int i = 0; i < m; i++) {
            from[i] = sc.nextInt()-1;
            to[i] = sc.nextInt()-1;
            eq[i] = sc.nextInt();
        }
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 30; j++) {
                if ((eq[i] & 1 << j) > 0){
                    v[from[i]][j]++;
                    v[to[i] + 1][j]--;
                }
            }
        }
        
        for (int i = 0; i < 30; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += v[j][i];
                v[j][i] = sum > 0 ? 1 : 0;
                sums[j][i] = (j == 0 ? 0 : sums[j-1][i]) + v[j][i];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 30; j++) {
                if ((eq[i] & 1 << j) == 0){
                    if ((sums[to[i]][j] - (from[i] == 0 ? 0 : sums[from[i] - 1][j])) == (to[i] - from[i] + 1)){
                        System.out.println("NO");
                        return;
                    }
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int val = 0;
            for (int j = 0; j < 30; j++) {
                if (v[i][j] == 1){
                    val |= 1 << j;
                }
            }
            sb.append(val).append(' ');
        }
        System.out.println("YES");
        System.out.println(sb);
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