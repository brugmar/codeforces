package codeforces.brugmar.codeforces.div2.A;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class CR252_A {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            boolean found = false;
            for (int j = 0; j < s; j++) {
                if (sc.nextInt() < m && !found){
                    sb.append(i + 1).append(' ');
                    count++;
                    found = true;
                }
            }
        }
        
        System.out.println(count);
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