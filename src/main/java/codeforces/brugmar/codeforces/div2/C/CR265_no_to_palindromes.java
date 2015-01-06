package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR265_no_to_palindromes {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int p = sc.nextInt();
        StringBuilder s = new StringBuilder(sc.next());

        int k = s.length() - 1;
        while (k >= 0) {
            char ch = s.charAt(k);
            for (int u = 0; u < 3; u++) {
                ch++;
                if (ch - 'a' >= p) {
                    break;
                } else if (k == 0 || (k == 1 && ch != s.charAt(k - 1)) || (ch != s.charAt(k - 1) && ch != s.charAt(k - 2))) {
                    s.setCharAt(k, ch);
                    for (int j = k + 1; j < s.length(); j++) {
                        ch = 'a' - 1;
                        for (int l = 0; l < 3; l++) {
                            ch++;
                            if (ch - 'a' >= p) {
                                System.out.println("NO");
                                return;
                            } else if ((j == 1 && ch != s.charAt(j - 1)) || (ch != s.charAt(j - 1) && ch != s.charAt(j - 2))) {
                                s.setCharAt(j, ch);
                                break;
                            }
                        }
                    }
                    System.out.println(s.toString());
                    return;
                }
            }
            k--;
        }
        System.out.println("NO");
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
