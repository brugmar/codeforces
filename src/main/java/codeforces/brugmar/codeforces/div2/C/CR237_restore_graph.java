package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR237_restore_graph {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int k = sc.nextInt();

        Pair[] d = new Pair[n];
        for (int i = 0; i < n; i++) {
            d[i] = new Pair(sc.nextInt(), i+1);
        }

        Arrays.sort(d, (a, b) -> a.v - b.v);

        if (d[0].v != 0 || (d.length > 1 && d[1].v == 0)) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Integer> q = new ArrayDeque<>();
        ArrayDeque<Integer> newQ = new ArrayDeque<>();
        int parent = 0;
        newQ.add(d[0].ind);
        int counter = k - 1;

        for (int i = 1; i < n; i++) {
            if (d[i].v != d[i - 1].v) {
                q = newQ;
                newQ = new ArrayDeque<>();
                if (d[i].v != d[i - 1].v + 1 || q.isEmpty()) {
                    System.out.println("-1");
                    return;
                }
                parent = q.poll();
                counter = (i == 1) ? k : k - 1;
            }

            if (counter == 0) {
                if (q.isEmpty()) {
                    System.out.println("-1");
                    return;
                } else {
                    parent = q.poll();
                    counter = k - 1;
                }
            }
            counter--;
            int node = d[i].ind;
            sb.append(parent).append(' ').append(node).append('\n');
            newQ.push(node);
        }

        System.out.println(n-1);
        System.out.print(sb.toString());
    }
    
    static class Pair {
        int v;
        int ind;

        public Pair(int v, int ind) {
            this.v = v;
            this.ind = ind;
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
