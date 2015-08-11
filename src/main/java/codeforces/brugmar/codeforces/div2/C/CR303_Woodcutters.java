package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR303_Woodcutters {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        int n = sc.nextInt();

        int[] v = new int[n];
        int[] h = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
            h[i] = sc.nextInt();
        }

        int last = v[0];
        int c = 1;
        for (int i = 1; i < n; i++) {
            int left = v[i] - h[i];
            int right = v[i] + h[i];
            if (left > v[i - 1] && left > last) {
                last = v[i];
                c++;
            } else if (i == n-1 || right < v[i+1]){
                last = right;
                c++;
            }
        }
        
        System.out.println(c);
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
