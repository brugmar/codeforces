package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR241_booking_system {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        Group[] g = new Group[n];
        for (int i = 0; i < n; i++) {
            g[i] = new Group(sc.nextInt(), sc.nextInt(), i + 1);
        }
        Arrays.sort(g, (a, b) -> b.m - a.m);

        int m = sc.nextInt();
        Pair[] t = new Pair[m];
        for (int i = 0; i < m; i++) {
            t[i] = new Pair(sc.nextInt(), i+1);
        }

        Arrays.sort(t, (a,b) -> a.v - b.v);

        int req = 0;
        int sum = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Group g1 = g[i];
            int table = findTable(t, g1);
            if (table != -1) {
                while (table < t.length && t[table].v < 0) {
                    table++;
                }
                if (table < t.length) {
                    req++;
                    sum += g1.m;
                    t[table].v = -t[table].v;
                    sb.append(g1.n).append(' ').append(t[table].i).append('\n');
                }
            }
        }

        System.out.println(req + " " + sum);
        System.out.println(sb.toString());
    }

    private static int findTable(Pair[] t, Group g) {
        int l = 0;
        int r = t.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            int v = Math.abs(t[m].v);
            if (g.p <= v && (m == 0 || Math.abs(t[m - 1].v) < g.p)) {
                return m;
            }

            if (v >= g.p) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return -1;

    }

    static class Group {
        int p;
        int m;
        int n;

        public Group(int p, int m, int n) {
            this.p = p;
            this.m = m;
            this.n = n;
        }
    }
    
    static class Pair {
        int v;
        int i;

        public Pair(int v, int i) {
            this.v = v;
            this.i = i;
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
