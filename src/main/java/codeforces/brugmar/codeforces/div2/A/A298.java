package codeforces.brugmar.codeforces.div2.A;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class A298 {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();

        if (n == 1) {
            System.out.println("1\n1");
        } else if (n == 2) {
            System.out.println("1\n1");
        } else if (n == 3) {
            System.out.println("2\n1 3");
        } else if (n == 4) {
            System.out.println("4\n3 1 4 2");
        } else {
            int l = 1;
            int r = n;

            int[] tab = new int[n+2];
            for (int i = 0; i < n; i += 2) {
                tab[i] = l++;
                tab[i + 1] = r--;
            }
            tab[0] = tab[n - 1];
            tab[n - 1] = 1;

            StringBuilder sb = new StringBuilder(n);
            sb.append(n).append("\n");
            for (int i = 0; i < n; i++) {
                sb.append(tab[i]).append(' ');
            }
            System.out.println(sb.toString());
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
