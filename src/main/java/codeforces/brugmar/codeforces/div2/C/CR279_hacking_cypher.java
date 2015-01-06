package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR279_hacking_cypher {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        String p = sc.next();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = p.length();

        int[] ar = getModsFromFirst(p, a);
        int[] br = getModsFromLast(p, b);

        for (int i = 0; i <= p.length() - 2; i++) {
            if (ar[i] == 0 && br[i + 1] == 0 && p.charAt(i + 1) != '0') {
                System.out.println("YES");
                System.out.println(p.substring(0, i + 1));
                System.out.println(p.substring(i + 1, n));
                return;
            }
        }

        System.out.println("NO");
    }

    private static int[] getModsFromLast(String num, int d) {
        int n = num.length();
        int[] ar = new int[n];
        int rest = (num.charAt(n - 1) - '0') % d;
        ar[n - 1] = rest;
        int tenRest = 10 % d;
        for (int i = ar.length - 2; i >= 0; i--) {
            int v = num.charAt(i) - '0';
            rest = (rest + (v * tenRest)) % d;
            ar[i] = rest;
            tenRest = (10 * tenRest) % d;
        }
        return ar;
    }

    private static int[] getModsFromFirst(String num, int d ) {
        int n = num.length();
        int[] ar = new int[n];
        int rest = 0;
        for (int i=0; i < n; i++){
            int v = num.charAt(i) - '0';
            rest = (rest * 10 + v) % d;
            ar[i] = rest;
        }
        return ar;
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
