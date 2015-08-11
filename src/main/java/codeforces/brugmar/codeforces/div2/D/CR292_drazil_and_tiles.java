package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class CR292_drazil_and_tiles {

    private static final int[] cs = {-1, 0, 1, 0};
    private static final int[] rs = {0, -1, 0, 1};

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] t = new char[n][m];
        byte[][] d = new byte[n][m];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                t[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    int nr = i + rs[k];
                    int nc = j + cs[k];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && t[nr][nc] == '.') {
                        d[i][j]++;
                    }
                }
            }
        }

        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (d[i][j] == 1) {
                    q.add(i * m + j);
                }
            }
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            int vr = v / m;
            int vc = v % m;
            if (t[vr][vc] == '.') {
                int r = 0;
                int c = 0;
                for (int i = 0; i < 4; i++) {
                    int nr = vr + rs[i];
                    int nc = vc + cs[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && t[nr][nc] == '.') {
                        r = nr;
                        c = nc;
                        break;
                    }
                }
                if (r == vr) {
                    t[r][Math.min(vc, c)] = '<';
                    t[r][Math.max(vc, c)] = '>';
                } else {
                    t[Math.min(vr, r)][c] = '^';
                    t[Math.max(vr, r)][c] = 'v';
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + rs[i];
                    int nc = c + cs[i];
                    if (nr >= 0 && nr < n && nc >= 0 && nc < m && t[nr][nc] == '.') {
                        d[nr][nc]--;
                        if (d[nr][nc] == 1) {
                            q.add(nr * m + nc);
                        }
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (t[i][j] == '.') {
                    System.out.println("Not unique");
                    return;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(new String(t[i])).append('\n');
        }
        System.out.println(sb.toString());
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
