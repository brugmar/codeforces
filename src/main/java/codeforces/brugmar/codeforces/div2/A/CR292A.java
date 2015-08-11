package codeforces.brugmar.codeforces.div2.A;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR292A {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int a = sc.nextInt();
        int b = sc.nextInt();
        long s = sc.nextLong();
        
        s -= Math.abs(a);
        s -= Math.abs(b);
        System.out.println(s >= 0 && s % 2 == 0 ? "Yes" : "No");
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