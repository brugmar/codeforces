package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR274_exams {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            pairs[i] = new Pair(a, b);
        }

        Arrays.sort(pairs);

        int lastRealDate = 0;
        int maxDay = 0;

        for (int i = 0; i < n; i++) {
            if (maxDay > pairs[i].b){
                maxDay = Math.max(maxDay, pairs[i].a);
            } else {
                maxDay = (pairs[i].a >= lastRealDate) ? pairs[i].b : lastRealDate;
            }
            lastRealDate = pairs[i].a;
        }

        System.out.println(maxDay);
    }

    static class Pair implements Comparable<Pair> {

        int a;
        int b;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public int compareTo(Pair p) {
            return (b != p.b) ? b - p.b : a - p.a;
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
