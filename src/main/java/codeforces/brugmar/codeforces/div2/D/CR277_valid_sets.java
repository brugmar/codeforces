package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR277_valid_sets {

    private static final int M = 1000000007;
    private static int[][] g;
    private static boolean[] visited;
    private static int[] v;
    private static int diff;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        diff = sc.nextInt();
        int n = sc.nextInt();

        v = new int[n];

        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[] from = new int[n - 1];
        int[] to = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            from[i] = sc.nextInt();
            to[i] = sc.nextInt();
        }

        g = calculateGraph(n, from, to);
        visited = new boolean[n];

        long out = 0;
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited, false);
            out = (out + dfs(i, i)) % M;
        }
        System.out.println(out);
    }

    private static long dfs(int i, int min) {
        long out = 1;
        visited[i] = true;
        for (int j = 0; j < g[i].length; j++) {
            int child = g[i][j];
            if (!visited[child] && v[child] >= v[min] && v[child] - v[min] <= diff && (v[child] != v[min] || child > min)) {
                out = (out * (dfs(child, min) + 1)) % M;
            }
        }
        return out;
    }

    private static int[][] calculateGraph(int n, int[] from, int[] to) {
        int[][] g = new int[n][];
        int[] degree = calculateDegree(n, from, to);
        for (int i = 0; i < n; i++) {
            g[i] = new int[degree[i]];
        }
        Arrays.fill(degree, 0);
        for (int i = 0; i < from.length; i++) {
            int a = from[i] - 1;
            int b = to[i] - 1;
            g[a][degree[a]++] = b;
            g[b][degree[b]++] = a;
        }
        return g;
    }

    private static int[] calculateDegree(int n, int[] from, int[] to) {
        int[] degree = new int[n];
        for (int i = 0; i < from.length; i++) {
            degree[from[i] - 1]++;
            degree[to[i] - 1]++;
        }
        return degree;
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
