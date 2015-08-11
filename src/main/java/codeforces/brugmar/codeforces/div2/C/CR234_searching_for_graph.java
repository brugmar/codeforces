package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR234_searching_for_graph {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int t = sc.nextInt();
        
        _nextTest:
        for (int tt = 0; tt < t; tt++) {
            int n = sc.nextInt();
            int p = sc.nextInt();

            boolean[][] g = new boolean[n][n];
            int prevNode = 0;
            for (int i = 0; i < n; i++) {
                int nextNode = (prevNode + 1) % n;
                System.out.println((prevNode + 1) + " " + (nextNode + 1));
                g[prevNode][nextNode] = g[nextNode][prevNode] = true;
                prevNode = nextNode;
            }
            prevNode = 0;
            for (int i = 0; i < n; i++) {
                int nextNode = (prevNode + 2) % n;
                if (g[prevNode][nextNode]) {
                    prevNode = (prevNode + 1) % n;
                    nextNode = (prevNode + 2) % n;
                }
                System.out.println((prevNode + 1) + " " + (nextNode + 1));
                g[prevNode][nextNode] = g[nextNode][prevNode] = true;
                prevNode = nextNode;
            }

            int c = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i+1; j < n; j++) {
                    if (c == p) {
                        continue _nextTest;
                    }
                    if (!g[i][j]) {
                        g[i][j] = g[j][i] = true;
                        System.out.println((i + 1) + " " + (j + 1));
                        c++;
                    }
                }
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
