package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR244_match_and_catch {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        char[] a = sc.next().toCharArray();
        char[] b = sc.next().toCharArray();

        int[][] lcpAA = lcp(a, a);
        int[] aMinPref = minPref(a, lcpAA);
        int[][] lcpBB = lcp(b,b);
        int[] bMinPref = minPref(b, lcpBB);
        
        int[][] lcpAB = lcp(a,b);
        int sol = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int maxUniqPref = Math.max(aMinPref[i], bMinPref[j]);
                if (lcpAB[i][j] >= maxUniqPref){
                    sol = Math.min(sol, maxUniqPref);
                }
            }
        }
        System.out.println(sol == Integer.MAX_VALUE ? -1 : sol);
    }

    private static int[][] lcp(char[] a, char[] b) {
        int[][] out = new int[a.length][b.length];
        for (int i = a.length-1; i >= 0 ; i--) {
            for (int j = b.length-1; j >= 0; j--) {
                if (a[i] == b[j]) {
                    out[i][j] = 1 + ((i == a.length-1 || j == b.length-1) ? 0 : out[i + 1][j + 1]);
                } else {
                    out[i][j] = 0;
                }
            }
        }
        return out;
    }

    private static int[] minPref(char[] a, int[][] lcpAA) {
        int[] minPref = new int[a.length];
        for (int i = 0; i < lcpAA.length; i++) {
            int val = 0;
            for (int j = 0; j < lcpAA.length; j++) {
                if (i != j) {
                    val = Math.max(val, lcpAA[i][j]);
                }
            }
            minPref[i] = val+1;
        }
        return minPref;
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
