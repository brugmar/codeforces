package codeforces.brugmar.codeforces.div2.B;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CR294_B {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        
        int[] err = new int[n];
        for (int i = 0; i < n; i++) {
            err[i] = sc.nextInt();
        }
        
        Arrays.sort(err);
        
        int[] err1 = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            err1[i] = sc.nextInt();
        }
        
        Arrays.sort(err1);
        
        boolean found = false;
        for (int i = 0; i < n-1; i++) {
            if (err[i] != err1[i]){
                System.out.println(err[i]);
                found = true;
                break;
            }
        }
        
        if (!found){
            System.out.println(err[n-1]);
        }
        
        err = new int[n-2];
        for (int i = 0; i < n-2; i++) {
            err[i] = sc.nextInt();
        }
        
        Arrays.sort(err);
        
        for (int i = 0; i < n-2; i++) {
            if (err1[i] != err[i]){
                System.out.println(err1[i]);
                return;
            }
        }
        
        System.out.println(err1[n-2]);
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