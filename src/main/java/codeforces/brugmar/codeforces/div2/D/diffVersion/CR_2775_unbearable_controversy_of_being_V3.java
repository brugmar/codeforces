package codeforces.brugmar.codeforces.div2.D.diffVersion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR_2775_unbearable_controversy_of_being_V3 {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] from = new int[m];
        int[] to = new int[m];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            from[i] = a;
            to[i] = b;
        }

        int[][] edges = GraphUtils.getEdgesDirectedUnweighted(n, from, to);
        int[][] redges = GraphUtils.getEdgesDirectedUnweighted(n, to, from);

        boolean[] visited = new boolean[n];
        int out = 0;
        for (int i = 0; i < n; i++) {
            clean(visited);
            for (int v : edges[i]) {
                visited[v] = true;
            }

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int count = 0;
                    for (int v : redges[j]) {
                        if (visited[v]) {
                            count++;
                        }
                    }
                    if (count >= 2) {
                        out += (count - 1) * count / 2;
                    }
                }
            }

        }

        System.out.println(out);
    }

    private static void clean(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
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

class GraphUtils {

    public static int[] getOutcomingDegree(int n, int[] v, int[] u) {
        int[] deg = new int[n];
        int m = v.length;
        for (int i = 0; i < m; i++) {
            deg[v[i]]++;
        }
        return deg;
    }


    public static int[][] getEdgesDirectedUnweighted(int n, int[] v, int[] u) {
        int[][] edges = new int[n][];
        int[] deg = getOutcomingDegree(n, v, u);
        for (int i = 0; i < n; i++) {
            edges[i] = new int[deg[i]];
        }
        int m = v.length;
        Arrays.fill(deg, 0);
        for (int i = 0; i < m; i++) {
            edges[v[i]][deg[v[i]]++] = u[i];
        }
        return edges;
    }

    }
