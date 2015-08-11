package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR280_vanya_and_computer_game {

    final static byte XPlayer = 1;
    final static byte YPlayer = 2;
    final static byte Both = 0;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();

        byte[] sol = new byte[2000004];

        int c = 0;
        long xt = y;
        long yt = x;
        while (xt != yt) {
            c++;
            if (xt < yt) {
                sol[c] = XPlayer;
                xt += y;
            } else {
                sol[c] = YPlayer;
                yt += x;
            }
        }
        
        c++;
        for (int i = 0; i < n; i++) {
            int t = sc.nextInt();
            switch (sol[t % (c+1) % c]){
                case XPlayer:
                    System.out.println("Vanya");
                    break;
                case YPlayer:
                    System.out.println("Vova");
                    break;
                case Both:
                    System.out.println("Both");
                    break;
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
