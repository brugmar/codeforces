package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR273_table_decorations {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        long[] colours = new long[3];
        for (int i = 0; i < 3; i++) {
            colours[i] = sc.nextLong();
        }
        Arrays.sort(colours);

        long triples = colours[0];
        colours[1] -= triples;
        colours[2] -= triples;
        
        long twos = colours[1] / 2;
        colours[1] = colours[1] % 2;
        colours[2] -= twos;
        
        long pairsToBroke = Math.min(colours[2] / 3, triples + twos);
        long twos2 = pairsToBroke * 2;
        
        colours[2] -= pairsToBroke * 3;
        twos2 += (colours[2] >= 2 && colours[1] == 1) ? 1 : 0;

        long tables = triples + twos - pairsToBroke + twos2;
        System.out.println(tables);
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
