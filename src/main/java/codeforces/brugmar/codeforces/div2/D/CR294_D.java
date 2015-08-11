package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class CR294_D {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int alpSize = 'z' - 'a' + 1;
        int[] alp = new int[alpSize];

        for (int i = 0; i < alpSize; i++) {
            alp[i] = sc.nextInt();
        }

        String s = sc.next();

        HashMap<Long, Integer>[] count = new HashMap[alpSize];

        for (int i = 0; i < alpSize; i++) {
            count[i] = new HashMap<>();
        }

        long sum = 0;
        long out = 0;
        for (int j = 0; j < s.length(); j++) {
            int currChar = s.charAt(j) - 'a';
            Integer c = count[currChar].get(sum);
            out += (c == null) ? 0 : c;
            sum += alp[currChar];
            inc(count[currChar], sum);
        }

        System.out.println(out);
    }

    private static void inc(HashMap<Long, Integer> count, long sum) {
        Integer v = count.get(sum);
        count.put(sum, v == null ? 1 : v + 1);
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
