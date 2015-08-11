package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR252_valera_and_tubes {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int h = sc.nextInt();
        int w = sc.nextInt();
        int k = sc.nextInt();

        int counter = 0;
        int max = 0;
        int a = 1;
        int b = 1;
        int t = 1;
        for (int i = 1; i <= w * h; i++) {
            if (counter == max) {
                max = (k == 1) ? w * h - i + 1 : 2;
                counter = 0;
                k--;
            }
            if (counter == 0) {
                if (i != 1){
                    System.out.println();
                }
                System.out.print( + max + " ");
            }
            
            System.out.print(a + " " + b + " ");
            b += t;
            
            if (b == 0 || b == w + 1){
                a++;
                t *= -1;
                b += t;
            }
            counter++;
        }
        System.out.println();
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
