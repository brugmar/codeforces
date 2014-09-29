package codeforces.brugmar.codeforces.div2.C;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class CR269_muh_and_house_of_cards {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        long n = sc.nextLong();
        
        long maxHeigh = 1;
        while (countCards(maxHeigh) < n){
            maxHeigh *= 2;
        }
        
        long floors = binsearchMaxFloor(n, maxHeigh);
        
        System.out.println((floors == 0) ? 0 : 1 + (floors-1)/3);
    }

    private static long countCards(long maxHeigh) {
        return ((6L + (maxHeigh-1) * 3L) * maxHeigh)/2 - maxHeigh;
    }

    private static long binsearchMaxFloor(long n, long maxHeigh) {
        long l = 1;
        long r = maxHeigh;
        
        while (l <= r){
            long m = l + (r-l)/2;
            long countedCards = countCards(m);
            long countedCardsPlus = countCards(m+1);
            if (countedCards <= n && countedCardsPlus > n){
                long leftCards = n - countedCards;
                return Math.max(0, m - (leftCards % 3));
            }
            
            else if (countedCardsPlus <= n){
                l = m + 1;
            }
            
            else if (countedCards > n) {
                r = m - 1;
            }
        }
        
        return 0;
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