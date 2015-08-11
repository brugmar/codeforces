package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CR2775_unbearable_controversy_of_being {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        ArrayList<Integer>[] edgs = new ArrayList[n];
        ArrayList<Integer>[] redgs = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            edgs[i] = new ArrayList<>();
            redgs[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            edgs[a].add(b);
            redgs[b].add(a);
        }

        boolean[] visited = new boolean[n];
        int out = 0;
        for (int i = 0; i < n; i++) {
            clean(visited);
            for (int v : edgs[i]) {
                visited[v] = true;
            }

            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int count = 0;
                    for (int v : redgs[j]) {
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
