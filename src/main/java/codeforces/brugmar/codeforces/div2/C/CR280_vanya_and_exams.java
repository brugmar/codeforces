package codeforces.brugmar.codeforces.div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class CR280_vanya_and_exams {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();
        int r = sc.nextInt();
        int avg = sc.nextInt();
        
        Pair[] grades = new Pair[n];
        
        for (int i = 0; i < n; i++) {
            grades[i] = new Pair(sc.nextInt(), sc.nextInt());
        }
        
        Arrays.sort(grades, (p1, p2) -> p1.esseys - p2.esseys); 
        long esseys = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += grades[i].grade;
        }
        long rest = 1L * avg * n - sum;
        int p = 0;
        while (rest > 0){
            Pair g = grades[p++];
            long gradeDiff = Math.min(rest, r-g.grade);
            esseys += gradeDiff * g.esseys;
            rest -= gradeDiff;
        }
        System.out.println(esseys);
    }
    
    public static class Pair {
        final int grade;
        final int esseys;

        public Pair(int g, int e) {
            this.grade = g;
            this.esseys = e;
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