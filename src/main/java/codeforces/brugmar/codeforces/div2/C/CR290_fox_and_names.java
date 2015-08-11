package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class CR290_fox_and_names {

    final private static int AS = 'z' - 'a' + 1;
    final private static byte NOT_VISITED = 0;
    final private static int TEMP_MARK = 1;
    final private static byte VISITED = 2;

    private static boolean[] mask;
    private static byte[] visited;
    private static Set<Integer>[] v;

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        mask = new boolean[n];
        visited = new byte[AS];
        v = new HashSet[AS];

        for (int i = 0; i < AS; i++) {
            v[i] = new HashSet<>();
        }

        String[] s = new String[n];
        int maxSize = -1;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            s[i] = str;
            maxSize = (str.length() > maxSize) ? str.length() : maxSize;
        }

        for (int i = 0; i < maxSize; i++) {
            for (int j = 1; j < n; j++) {
                if (!mask[j - 1] && s[j - 1].length() > i) {
                    if (s[j].length() > i) {
                        char prev = s[j - 1].charAt(i);
                        char curr = s[j].charAt(i);
                        if (prev != curr) {
                            mask[j - 1] = true;
                            v[prev - 'a'].add(curr - 'a');
                        }
                    } else {
                        System.out.println("Impossible");
                        return;
                    }
                }
            }
        }

        StringBuilder sol = new StringBuilder(AS);
        boolean isDAG = true;
        int ind = 0;
        while (isDAG && ind < AS) {
            isDAG &= topologicalSort(ind, sol);
            ind++;
        }

        if (isDAG) {
            System.out.println(sol.reverse().toString());
        } else {
            System.out.println("Impossible");
        }
    }

    private static boolean topologicalSort(int i, StringBuilder sol) {
        if (visited[i] == TEMP_MARK) {
            return false;
        }
        if (visited[i] == NOT_VISITED) {
            visited[i] = TEMP_MARK;
            for (Integer edge : v[i]) {
                if (!topologicalSort(edge, sol)) {
                    return false;
                }
            }
            visited[i] = VISITED;
            sol.append((char) (i + 'a'));
        }
        return true;
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
