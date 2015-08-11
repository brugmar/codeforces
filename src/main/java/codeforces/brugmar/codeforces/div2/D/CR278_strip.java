package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class CR278_strip {

    final static int MAX = 100050;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int diff = sc.nextInt();
        int l = sc.nextInt();

        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            v[i] = sc.nextInt();
        }

        int[] dp = new int[n + 1];
        int[] left = new int[n];

        ArrayDeque<Integer> min = new ArrayDeque<>();
        ArrayDeque<Integer> max = new ArrayDeque<>();

        min.add(0);
        max.add(0);

        int tail = 0;
        left[0] = 0;
        for (int i = 1; i < n; i++) {
            while (!min.isEmpty() && v[min.peekLast()] >= v[i]) {
                min.pollLast();
            }
            min.add(i);

            while (!max.isEmpty() && v[max.peekLast()] <= v[i]) {
                max.pollLast();
            }
            max.add(i);

            while (v[max.peekFirst()] - v[min.peekFirst()] > diff) {
                tail++;
                if (min.peekFirst() < tail) {
                    min.pollFirst();
                }
                if (max.peekFirst() < tail) {
                    max.pollFirst();
                }
            }
            left[i] = tail;
        }

        min = new ArrayDeque<>();
        min.addLast(0);
        int lMinPtr = 0;
        int rMinPtr = 1;
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            if (left[i - 1] > i - l) {
                dp[i] = MAX;
            } else {
                while (rMinPtr <= i - l) {
                    while (!min.isEmpty() && dp[min.peekLast()] >= dp[rMinPtr]) {
                        min.pollLast();
                    }
                    min.addLast(rMinPtr);
                    rMinPtr++;
                }
                
                while (lMinPtr < left[i - 1]) {
                    lMinPtr++;
                    if (!min.isEmpty() && min.peekFirst() < lMinPtr) {
                        min.pollFirst();
                    }
                }

                dp[i] = Math.min(MAX, 1 + (min.isEmpty() ? 0 : dp[min.peekFirst()]));
            }
        }

        System.out.println(dp[n] == MAX ? -1 : dp[n]);
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
