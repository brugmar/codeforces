package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CR244_checkposts {

    public static int M = 1000000007;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[] c = new int[n];
        boolean[] visited = new boolean[n];

        ArrayList<Integer>[] e = new ArrayList[n];
        ArrayList<Integer>[] ie = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            c[i] = sc.nextInt();
            e[i] = new ArrayList<>();
            ie[i] = new ArrayList<>();
        }

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            e[a].add(b);
            ie[b].add(a);
        }

        ArrayDeque<Integer> s = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dfs(i, visited, e, s);
        }

        clean(visited);

        long cost = 0;
        long comb = 1;
        while (!s.isEmpty()) {
            int v = s.pop();
            if (!visited[v]) {
                MinCount mc = minDfs(v, c, visited, ie);
                cost += mc.min;
                comb = (comb * mc.count) % M;
            }
        }

        System.out.println(cost + " " + comb);
    }

    private static void clean(boolean[] visited) {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    private static void dfs(int i, boolean[] visited, ArrayList<Integer>[] e, ArrayDeque<Integer> s) {
        if (!visited[i]) {
            visited[i] = true;
            for (int edge : e[i]) {
                dfs(edge, visited, e, s);
            }
            s.push(i);
        }
    }

    private static MinCount minDfs(int v, int[] c, boolean[] visited, ArrayList<Integer>[] e) {
        if (!visited[v]) {
            visited[v] = true;
            MinCount mc = new MinCount(c[v], 1);
            for (int edge : e[v]) {
                if (!visited[edge]) {
                    MinCount tmpMc = minDfs(edge, c, visited, e);
                    if (tmpMc.min < mc.min) {
                        mc = tmpMc;
                    } else if (tmpMc.min == mc.min) {
                        mc.count += tmpMc.count;
                    }
                }
            }
            return mc;
        }
        return new MinCount(Integer.MAX_VALUE, 0);
    }

    static class MinCount {

        int min;
        int count;

        public MinCount(int min, int count) {
            this.min = min;
            this.count = count;
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
