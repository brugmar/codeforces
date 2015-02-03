package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class CR251_devu_and_partitioning_of_the_array {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int p = sc.nextInt();

        ArrayDeque<Integer> even = new ArrayDeque<>();
        ArrayDeque<Integer> odd = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            int v = sc.nextInt();
            if (v % 2 == 0) {
                even.add(v);
            } else {
                odd.add(v);
            }
        }

        int evenSize = even.size();
        int oddSize = odd.size();

        evenSize -= p;
        if (evenSize < 0) {
            oddSize -= evenSize * -2;
            evenSize = 0;
        }

        oddSize -= k - p;

        if (evenSize < 0 || oddSize < 0 || oddSize % 2 == 1) {
            System.out.println("NO");
        } else {
            System.out.println("YES");

            for (int i = 0; i < Math.min(k - 1, k - p); i++) {
                System.out.println("1 " + odd.pollFirst());
            }

            for (int i = 0; i < p - 1; i++) {
                if (!even.isEmpty()) {
                    System.out.println("1 " + even.pollFirst());
                } else {
                    System.out.println("2 " + odd.pollFirst() + " " + odd.pollFirst());
                }
            }

            int lastSetSize = even.size() + odd.size();
            if (lastSetSize > 0) {
                StringBuilder sb = new StringBuilder();

                while (!even.isEmpty()) {
                    sb.append(even.pollFirst()).append(' ');
                }
                while (!odd.isEmpty()) {
                    sb.append(odd.pollFirst()).append(' ');
                }
                System.out.println(lastSetSize + " " + sb.toString());
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
