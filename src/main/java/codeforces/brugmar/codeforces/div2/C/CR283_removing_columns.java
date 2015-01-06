package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class CR283_removing_columns {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] rows = new String[n];
        for (int i = 0; i < n; i++) {
            rows[i] = sc.next();
        }

        if (n == 1) {
            System.out.println("0");
            return;
        }

        int c = 0;
        List<Segment> l = new LinkedList<>();
        l.add(new Segment(0, n));
        for (int i = 0; i < m; i++) {
            if (allSegmentsAreAscending(l, rows, i)) {
                c++;
                l = recomputeSegments(l, rows, i);
                if (l.isEmpty()) {
                    c += m - i - 1;
                    break;
                }
            }
        }
        System.out.println(m - c);
    }

    private static boolean allSegmentsAreAscending(List<Segment> l, String[] rows, int ind) {
        for (Segment s : l) {
            for (int i = s.a + 1; i < s.b; i++) {
                if (rows[i-1].charAt(ind) > rows[i].charAt(ind)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static List<Segment> recomputeSegments(List<Segment> l, String[] rows, int ind) {
        List<Segment> out = new LinkedList<>();
        for (Segment s : l) {
            int prev = -1;
            int start = -1;
            int end = -1;
            for (int i = s.a; i < s.b; i++) {
                int acc = rows[i].charAt(ind);
                if (prev == acc) {
                    end++;
                } else {
                    if (start != end) {
                        out.add(new Segment(start, end + 1));
                    }
                    start = i;
                    end = i;
                }
                prev = acc;
            }
            if (start != end) {
                out.add(new Segment(start, end + 1));
            }
        }
        return out;
    }

    static class Segment {

        final int a;
        final int b;

        public Segment(int a, int b) {
            this.a = a;
            this.b = b;
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
