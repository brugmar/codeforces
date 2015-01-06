package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR271_captain_marmot {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            Point[] p = new Point[4];
            Point[] t = new Point[4];

            for (int k = 0; k < 4; k++) {
                p[k] = new Point(sc.nextInt(), sc.nextInt());
                t[k] = new Point(sc.nextInt(), sc.nextInt());
            }

            int min = solve(p, t, 0, 0);
            System.out.println(min == Integer.MAX_VALUE ? -1 : min);
        }
    }

    private static int solve(Point[] points, Point[] t, int p, int moves) {
        if (p == 4) {
            return isCompact(points) ? moves : Integer.MAX_VALUE;
        } else {
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < 4; i++) {
                result = Math.min(result, solve(points, t, p + 1, moves + i));
                move(points, t, p);
            }
            return result;
        }
    }

    private static boolean isCompact(Point[] points) {
        long[] d = new long[6];
        int v = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = i + 1; j < 4; j++) {
                d[v++] = dist(points[i], points[j]);
            }
        }

        Arrays.sort(d);
        return d[0] != 0
                && d[0] == d[1] && d[1] == d[2] && d[2] == d[3]
                && d[3] != d[4]
                && d[4] == d[5];
    }

    private static long dist(Point a, Point b) {
        return (1L * a.x - b.x) * (a.x - b.x) + (1L * a.y - b.y) * (a.y - b.y);
    }

    private static void move(Point[] points, Point[] t, int p) {
        points[p] = new Point(-(points[p].y - t[p].y) + t[p].x, points[p].x - t[p].x + t[p].y);
    }

    static class Point implements Comparable<Point> {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point p) {
            if (x == p.x) {
                return y - p.y;
            } else {
                return x - p.x;
            }
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
