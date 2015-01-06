package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR278_fight_the_monster {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int hpY = sc.nextInt();
        int attY = sc.nextInt();
        int defY = sc.nextInt();
        
        int hpM = sc.nextInt();
        int attM = sc.nextInt();
        int defM = sc.nextInt();
        
        int hpC = sc.nextInt();
        int attC = sc.nextInt();
        int defC = sc.nextInt();
        
        int cost = Integer.MAX_VALUE;
        for (int a = Math.max(attY, defM + 1); a <= 200; a++){
            for (int d = defY; d <= 100; d++){
                int r = (int) (Math.ceil((float)hpM / (a - defM)));
                int hp = Math.max(0, 1 + (-1) * (hpY - r * (attM - d)));
                cost = Math.min(cost, hp * hpC + (a - attY) * attC + (d - defY) * defC);
                if (cost == 0) break;
            }
        }
        System.out.println(cost);
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