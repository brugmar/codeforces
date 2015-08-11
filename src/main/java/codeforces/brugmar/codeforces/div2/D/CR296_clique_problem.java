package codeforces.brugmar.codeforces.div2.D;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CR296_clique_problem {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        
        Segment[] sg = new Segment[n];
        
        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int w = sc.nextInt();
            sg[i] = new Segment(p-w, p+w);
        }

        Arrays.sort(sg, (a,b) -> a.r - b.r);
        
        Segment last = sg[0];
        int ans = 1;
        for (int i = 1; i < n; i++) {
            if (last.r <= sg[i].l){
                last = sg[i];
                ans++;
            }
        }
        System.out.println(ans);
    }
    
    static class Segment {
        int l;
        int r;

        public Segment(int l, int r) {
            this.l = l;
            this.r = r;
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