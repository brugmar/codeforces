package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR282_obsessive_string {

    private static final int M = 1000000007;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        String s = sc.next();
        String t = sc.next();

        int[] psTab = computePrefix(t);
        boolean[] foundText = kmp(s, t, psTab);

        int n = s.length();
        // dp[i] == all solution with letter s[i]
        long[] dp = new long[n + 1];
        long[] all = new long[n + 1];
        long[] sum = new long[n + 1];
        int[] lastStart = new int[n + 1];
        lastStart[0] = 0;
        int tN = t.length();

        for (int i = 1; i <= n; i++) {
            lastStart[i] = (i + tN - 1 <= n && foundText[i + tN - 2]) ? i : lastStart[i - 1];
            // prev
            dp[i] = dp[i - 1];
            if (foundText[i - 1]) {
                // curr
                int tmpLastStart = lastStart[i - t.length()];
                dp[i] = (dp[i] + (tmpLastStart == 0 ? i - t.length() + 1 : (i - tmpLastStart + 1 - tN))) % M;
                // all solutions + new substring
                dp[i] = (dp[i] + M + sum[i - t.length()] - sum[Math.max(0, tmpLastStart-1)]) % M;
            }
            all[i] = (all[i - 1] + dp[i]) % M;
            sum[i] = (sum[i - 1] + all[i]) % M;
        }

        System.out.println(all[s.length()]);
    }

    // http://en.wikipedia.org/wiki/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm
    private static int[] computePrefix(String w) {
        int[] t = new int[w.length()];

        int p = 2;
        int cnd = 0;

        t[0] = -1;

        while (p < w.length()) {
            if (w.charAt(p - 1) == w.charAt(cnd)) {
                cnd++;
                t[p] = cnd;
                p++;
            } else if (cnd > 0) {
                cnd = t[cnd];
            } else {
                t[p] = 0;
                p++;
            }
        }

        return t;
    }

    private static boolean[] kmp(String s, String w, int[] t) {
        int m = 0;
        int i = 0;
        boolean[] found = new boolean[s.length()];

        while (m + i < s.length()) {
            if (w.charAt(i) == s.charAt(m + i)) {
                if (i != w.length() - 1) {
                    i++;
                    continue;
                }
                found[m + i] = true;
            }
            if (t[i] > -1) {
                m = m + i - t[i];
                i = t[i];
            } else {
                i = 0;
                m++;
            }
        }

        return found;
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
