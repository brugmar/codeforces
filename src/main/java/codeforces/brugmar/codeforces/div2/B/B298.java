package codeforces.brugmar.codeforces.div2.B;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B298 {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int v1 = sc.nextInt();
        int v2 = sc.nextInt();

        int t = sc.nextInt();
        int d = sc.nextInt();

        int sum = v1;
        int last = v1;
        for (int i = 0; i < t - 1; i++) {
            int remTime = t - i - 2;
            int add = Math.min(v2 + remTime * d - last, d);
            last = (add < 0) ? last - Math.min(d, -add) : last + add;
            sum += last;
        }
        
        System.out.println(sum);
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
