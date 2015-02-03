package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CR248_ryoukos_memory_note {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int m = sc.nextInt();
        PriorityQueue<Integer>[] p = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            p[i] = new PriorityQueue<>();
        }

        int prev = -1;
        long globalSum = 0;
        for (int i = 0; i < m; i++) {
            int v = sc.nextInt()-1;
            if (prev != -1 && v - prev != 0) {
                p[v].add(prev - v);
                p[prev].add(v - prev);
                globalSum += Math.abs(prev - v);
            }
            prev = v;
        }

        long min = globalSum;
        for (int i = 0; i < n; i++) {
            long negativesum = 0;
            long positivesum = 0;
            long negativeCount = 0;
            long positiveCount = 0;
            for (int v : p[i]) {
                if (v < 0) {
                    negativesum += -v;
                    negativeCount++;
                } else {
                    positivesum += v;
                    positiveCount++;
                }
            }

            long localSum = negativesum + positivesum;

            PriorityQueue<Integer> q = p[i];
            long lessSum = 0;
            long moreSum = 0;
            long lessCount = 0;
            long moreCount = 0;
            while (!q.isEmpty()) {
                long newSum = 0;
                int v = q.poll();
                if (v < 0) {
                    v = -v;
                    lessCount++;
                    lessSum += v;

                    newSum += lessSum - lessCount * v;
                    newSum += (negativeCount - lessCount) * v - (negativesum - lessSum);
                    newSum += positivesum + positiveCount * v;

                } else {
                    moreSum += v;
                    moreCount++;

                    newSum += negativesum + negativeCount * v;
                    newSum += 1L * (moreCount * v) - moreSum;
                    newSum += (positivesum - moreSum) - (positiveCount - moreCount) * v;

                }
                min = Math.min(globalSum - localSum + newSum, min);
            }
        }
        
        System.out.println(min);
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
                while (line.isEmpty()){
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
