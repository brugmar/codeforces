package codeforces.brugmar.codeforces.div2.B;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR296_B {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int alSize = 'z' - 'a' + 1;

        int n = sc.nextInt();
        String a = sc.next();
        String b = sc.next();

        int diff = computeDiff(a, b);

        int[][] swaps = new int[alSize][alSize];

        for (int i = 0; i < a.length(); i++) {
            int x = a.charAt(i) - 'a';
            int y = b.charAt(i) - 'a';
            if (x != y) {
                swaps[x][y] = i + 1;
            }
        }

        for (int i = 0; i < alSize; i++) {
            for (int j = 0; j < alSize; j++) {
                if (swaps[i][j] > 0 && swaps[j][i] > 0) {
                    diff -= 2;
                    System.out.println(diff);
                    System.out.println(swaps[i][j] + " " + swaps[j][i]);
                    return;
                }
            }
        }

        int[] oneA = new int[alSize];
        int[] oneB = new int[alSize];
        for (int i = 0; i < alSize; i++) {
            for (int j = 0; j < alSize; j++) {
                oneA[i] += (swaps[i][j] > 0) ? swaps[i][j] : 0;
            }
            for (int j = 0; j < alSize; j++) {
                oneB[i] += (swaps[j][i] > 0) ? swaps[j][i] : 0;
            }
        }

        for (int i = 0; i < alSize; i++) {
            if (oneA[i] > 0 && oneB[i] > 0) {
                diff--;
                System.out.println(diff);
                System.out.println(oneA[i] + " " + oneB[i]);
                return;
            }
        }
        
        System.out.println(diff);
        System.out.println("-1 -1");
    }

    private static int computeDiff(String a, String b) {
        int c = 0;
        for (int i = 0; i < a.length(); i++) {
            c += a.charAt(i) != b.charAt(i) ? 1 : 0;
        }
        return c;
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
