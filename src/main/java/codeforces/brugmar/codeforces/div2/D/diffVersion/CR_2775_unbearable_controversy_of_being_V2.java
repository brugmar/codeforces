package codeforces.brugmar.codeforces.div2.D.diffVersion;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR_2775_unbearable_controversy_of_being_V2 {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        boolean[][] edMx = new boolean[n][n];
        int[][] edges = new int[n][];
        int[][] redges = new int[n][];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            edMx[a][b] = true;
        }

        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (edMx[i][j]) {
                    counter++;
                }
            }
            edges[i] = new int[counter];
            counter = 0;
            for (int j = 0; j < n; j++) {
                if (edMx[i][j]) {
                    edges[i][counter] = j;
                    counter++;
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            int counter = 0;
            for (int j = 0; j < n; j++) {
                if (edMx[j][i]) {
                    counter++;
                }
            }
            redges[i] = new int[counter];
            counter = 0;
            for (int j = 0; j < n; j++) {
                if (edMx[j][i]) {
                    redges[i][counter] = j;
                    counter++;
                }
            }
        }

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
