package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CR245_xor_tree {

    static ArrayList<Integer> sol = new ArrayList<>();
    static ArrayList<Integer>[] e;
    static byte[] init;
    static byte[] g;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        sol = new ArrayList<>();
        e = new ArrayList[n];
        init = new byte[n];
        g = new byte[n];

        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            e[a].add(b);
            e[b].add(a);
        }

        for (int i = 0; i < n; i++) {
            init[i] = (byte) sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            g[i] = (byte) sc.nextInt();
        }

        dfs(0, -1, 0, 0, 0);

        System.out.println(sol.size());
        for (int vertex : sol) {
            System.out.println(vertex);
        }
    }

    private static void dfs(int i, int parent, int h, int even, int odd) {
        int k = init[i];
        boolean heightIsEven = h % 2 == 0;
        k ^= (heightIsEven) ? even : odd;
        if (k != g[i]) {
            sol.add(i + 1);
            if (heightIsEven) {
                even ^= 1;
            } else {
                odd ^= 1;
            }
        }
        for (int neighbour : e[i]) {
            if (neighbour != parent) {
                dfs(neighbour, i, h + 1, even, odd);
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
