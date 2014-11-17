package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR277_palindrome_transformation {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int p = sc.nextInt();
        String str = sc.next();

        int firstDiff = -1;
        int lastDiff = -1;
        int count = 0;

        for (int i = 0; i < str.length() / 2; i++) {
            int left = str.charAt(i);
            int right = str.charAt(n - i - 1);
            if (left != right) {
                int less = (left < right) ? left : right;
                int more = (left >= right) ? left : right;
                count += Math.min(more - less, less - 'a' + 'z' - more + 1);
                if (firstDiff == -1) {
                    firstDiff = i;
                }
                lastDiff = i;
            }
        }

        if (firstDiff != -1) {
            if (p > str.length() / 2) {
                p = str.length() - p + 1;
            }
            p--;
            lastDiff = Math.max(lastDiff, p);
            firstDiff = Math.min(firstDiff, p);

            count += Math.min(2 * (p - firstDiff) + lastDiff - p,
                    2 * (lastDiff - p) + p - firstDiff);
        }
        System.out.println(count);
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
