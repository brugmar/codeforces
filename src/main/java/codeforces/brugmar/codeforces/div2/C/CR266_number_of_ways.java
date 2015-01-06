package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR266_number_of_ways {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            t[i] = sc.nextInt();
        }

        long sum = 0;
        Pair[] sortedSums = new Pair[n];
        long[] sums = new long[n];
        for (int i = 0; i < n; i++) {
            sum += t[i];
            sortedSums[i] = new Pair(sum, i);
            sums[i] = sum;
        }

        Arrays.sort(sortedSums, (p1, p2)
                -> ((p1.sum == p2.sum) ? p1.indx - p2.indx : ((p1.sum < p2.sum) ? -1 : 1)));

        long sol = 0;
        for (int i = n - 1; i >= 1; i--) {
            long thidSum = sums[n - 1] - sums[i - 1];
            if (sums[i - 1] - thidSum == thidSum) {
                int firstInd = findFirstSum(sortedSums, thidSum, i);
                if (firstInd != -1) {
                    int findLasInd = findLastSum(sortedSums, thidSum, i);
                    sol += findLasInd - firstInd + 1;
                }
            }
        }

        System.out.println(sol);
    }

    private static int findFirstSum(Pair[] sortedSums, long key, int i) {
        int l = 0;
        int r = sortedSums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            Pair mp = sortedSums[m];
            if (mp.indx < i - 1 && mp.sum == key && (m == 0 || sortedSums[m - 1].sum != key)) {
                return m;
            }

            if (mp.sum >= key) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    private static int findLastSum(Pair[] sortedSums, long key, int i) {
        int l = 0;
        int r = sortedSums.length - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;
            Pair mp = sortedSums[m];
            if (mp.indx < i - 1 && mp.sum == key && (m == sortedSums.length - 1 || sortedSums[m + 1].indx >= i - 1 || sortedSums[m + 1].sum != key)) {
                return m;
            }

            if (mp.sum > key || (mp.sum == key && mp.indx >= i - 1)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }

        return -1;
    }

    static class Pair {

        public final long sum;
        public final int indx;

        public Pair(long sum, int inx) {
            this.sum = sum;
            this.indx = inx;
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
