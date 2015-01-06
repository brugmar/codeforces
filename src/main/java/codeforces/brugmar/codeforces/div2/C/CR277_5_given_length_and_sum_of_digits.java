package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR277_5_given_length_and_sum_of_digits {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int m = sc.nextInt();
        int s = sc.nextInt();
        
        if (m == 1 && s == 0){
            System.out.println("0 0");
            return;
        }

        if (s == 0 || (9 * m) < s) {
            System.out.println("-1 -1");
            return;
        }

        int[] min = new int[m];
        int[] max = new int[m];
        for (int i = 0; i < m; i++) {
            min[i] = 9;
            max[i] = 9;
        }

        int acc_sum = 9 * m;
        for (int i = 0; i < m; i++) {
            if (acc_sum == s) {
                break;
            }

            int maxSub = (i == 0) ? 8 : 9;
            int sub = Math.min(maxSub, acc_sum - s);
            min[i] -= sub;
            acc_sum -= sub;
        }

        System.out.print(convertToString(min) + " ");

        acc_sum = 9 * m;
        for (int i = m-1; i >= 0; i--) {
            if (acc_sum == s) {
                break;
            }

            int maxSub = (i == 0) ? 8 : 9;
            int sub = Math.min(maxSub, acc_sum - s);
            max[i] -= sub;
            acc_sum -= sub;
        }
        System.out.println(convertToString(max));
    }

    private static String convertToString(int[] values) {
        StringBuilder sb = new StringBuilder();
        for (int i : values) {
            sb.append(i);
        }
        return sb.toString();
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
