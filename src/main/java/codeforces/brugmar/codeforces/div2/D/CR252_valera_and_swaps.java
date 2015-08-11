package codeforces.brugmar.codeforces.div2.D;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class CR252_valera_and_swaps {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();

        int[] vls = new int[n];
        int[] pc = new int[n];
        ArrayList<Integer> cStart = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            vls[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int minSwp = 0;

        int mark = 0;
        for (int i = 0; i < n; i++) {
            if (pc[i] == 0) {
                mark++;
                int ind = i;
                int counter = 0;
                while (vls[ind] != i + 1) {
                    pc[ind] = mark;
                    counter++;
                    ind = vls[ind] - 1;
                }
                pc[ind] = mark;
                minSwp += counter;
                cStart.add(i);
            }
        }

        StringBuilder out = new StringBuilder();
        int diff = Math.abs(m - minSwp);
        out.append(diff).append('\n');
        if (m >= minSwp) {
            for (int i = 0; i < diff; i++) {
                int tmp = cStart.get(i + 1);
                out.append(1).append(' ').append(tmp + 1).append(' ');
            }
        } else {
            int counter = 0;
            int ind = 0;
            boolean inCycle[] = new boolean[n];
            while (counter < diff) {
                if (vls[ind] != ind + 1) {
                    Arrays.fill(inCycle, false);
                    for (int val = vls[ind] - 1; val != ind; val = vls[val] - 1) {
                        inCycle[val] = true;
                    }
                    
                    int p = ind+1;
                    while(!inCycle[p]){
                        p++;
                    }
                    
                    out.append(ind+1).append(' ').append(p+1).append(' ');
                    
                    int tmp = vls[ind];
                    vls[ind] = vls[p];
                    vls[p] = tmp;
                    
                    counter++;
                } else {
                    ind++;
                }
            }
        }
        System.out.println(out);
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
