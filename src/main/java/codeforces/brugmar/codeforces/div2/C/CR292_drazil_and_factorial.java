package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR292_drazil_and_factorial {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();

        sc.nextInt();

        String num = sc.next();

        int[] buck = new int[10];

        for (int i = 0; i < num.length(); i++) {
            int base = num.charAt(i) - '0';
            for (int j = 2; j <= base; j++) {
                int v = j;
                switch (v) {
                    case 1:
                    case 0:
                        break;
                    case 4:
                        buck[2] += 2;
                        break;
                    case 6:
                        buck[2]++;
                        buck[3]++;
                        break;
                    case 8:
                        buck[2] += 3;
                        break;
                    case 9:
                        buck[3] += 2;
                        break;
                    default:
                        buck[v]++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 9; i >= 2; i--) {
            int v = buck[i];
            if (v > 0) {
                for (int j = 0; j < v; j++) {
                    sb.append(i);
                }
                
                for (int k = 2; k <= i; k++) {
                    switch (k) {
                        case 6:
                            buck[2]-= v;
                            buck[3]-= v;
                            break;
                        case 4:
                            buck[2] -= 2*v;
                            break;
                        default:
                            buck[k] -= v;
                    }
                }
            }
        }

        System.out.println(sb.toString());
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
