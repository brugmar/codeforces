package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class CR268_two_sets {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        if (a == b) {
            System.out.println("NO");
            return;
        }

        Map<Integer, Integer> v = new HashMap<>();
        int[] vTab = new int[n];
        byte[] belong = new byte[n];

        for (int i = 0; i < n; i++) {
            vTab[i] = sc.nextInt();
            v.put(vTab[i], i);
        }

        for (int i = 0; i < n; i++) {
            int val = vTab[i];
            belong[i] |= v.containsKey(a - val) ? 1 : 0;
            belong[i] |= v.containsKey(b - val) ? 2 : 0;
        }

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                Integer ind = null;
                if (belong[i] == 1 && (ind = v.get(a - vTab[i])) != null) {
                    belong[ind] = 1;
                } else if (belong[i] == 2 && (ind = v.get(b - vTab[i])) != null) {
                    belong[ind] = 2;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            if (belong[i] == 3) {
                belong[i] = 1;
            }
        }

        for (int i = 0; i < n; i++) {
            Integer ind;
            if (belong[i] == 1 && (ind = v.get(a - vTab[i])) != null && belong[ind] == 1) {
                continue;
            }
            if (belong[i] == 2 && (ind = v.get(b - vTab[i])) != null && belong[ind] == 2) {
                continue;
            }
            System.out.println("NO");
            return;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(belong[i] - 1).append(' ');
        }
        System.out.println("YES");
        System.out.println(sb);
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
