package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR283_tennis_game {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        int n = sc.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];
        int[] aInv = new int[n + 1];
        int[] bInv = new int[n + 1];
        StringBuilder[] winsTab = new StringBuilder[n + 1];

        for (int i = 0; i <= n; i++) {
            winsTab[i] = new StringBuilder();
        }

        for (int i = 0; i < n; i++) {
            int winner = sc.nextInt();
            a[i] = ((i == 0) ? 0 : a[i - 1]) + ((winner == 1) ? 1 : 0);
            b[i] = ((i == 0) ? 0 : b[i - 1]) + ((winner == 2) ? 1 : 0);
        }

        Arrays.fill(aInv, Integer.MAX_VALUE);
        Arrays.fill(bInv, Integer.MAX_VALUE);
        for (int i = 0; i < n; i++) {
            aInv[a[i]] = Math.min(aInv[a[i]], i);
            bInv[b[i]] = Math.min(bInv[b[i]], i);
        }

        int count = 0;
        for (int i = 1; i <= n; i++) {
            int wins = testOtherWins(a, aInv, b, bInv, i);
            if (wins != 0) {
                count++;
                winsTab[wins].append(wins).append(' ').append(i).append('\n');
            }
        }

        StringBuilder out = new StringBuilder();
        for (int i = 0; i <= n; i++) {
            if (winsTab[i].length() != 0) {
                out.append(winsTab[i]);
            }
        }
        System.out.println(count);
        System.out.println(out.toString());
    }

    private static int testOtherWins(int[] a, int[] aInv, int[] b, int[] bInv, int p) {
        int points = p;
        int ac = 0;
        int bc = 0;
        int aPtr = aInv[p];
        int bPtr = bInv[p];
        int ptr;
        int prevA = 0;
        int prevB = 0;
        boolean aWins = false;
        boolean bWins = false;
        int prevAPtr = 0;
        int prevBPtr = 0;
        while ((ptr = Math.min(aPtr, bPtr)) != Integer.MAX_VALUE) {
            if (a[ptr] - prevA > b[ptr] - prevB) {
                ac++;
                bWins = !(aWins = true);
            } else {
                bc++;
                aWins = !(bWins = true);
            }
            prevA = a[ptr];
            prevB = b[ptr];
            prevAPtr = aPtr;
            prevBPtr = bPtr;
            aPtr = (a[ptr] + points >= aInv.length) ? Integer.MAX_VALUE : aInv[a[ptr] + points];
            bPtr = (b[ptr] + points >= bInv.length) ? Integer.MAX_VALUE : bInv[b[ptr] + points];
        }

        if (ac > bc && aWins && prevAPtr == a.length - 1) {
            return ac;
        } else if (bc > ac && bWins && prevBPtr == b.length - 1) {
            return bc;
        } else {
            return 0;
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
