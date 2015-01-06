package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR284_crazy_town {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();

        int n = sc.nextInt();

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            float vx1 = (b == 0) ? -(float) c / a : 1;
            float vy1 = (b == 0) ? 1 : (-(float) c - a) / b;
            float vx2 = (b == 0) ? vx1 : 2;
            float vy2 = (b == 0) ? 2 : (-(float) c - 2 * a) / b;
            float vx = vx1 - vx2;
            float vy = vy1 - vy2;

            if (Math.signum(crossProduct(vx1 - x1, vy1 - y1, vx, vy)) 
                    != Math.signum(crossProduct(vx1 - x2, vy1 - y2, vx, vy))) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }

    private static double crossProduct(float x1, float y1, float x2, float y2) {
        return (double) x1 * y2 - (double) x2 * y1;
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
