package codeforces.brugmar.codeforces.div2.A;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class CR294_A {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        Map<Character, Integer> w = new HashMap<>();
        //'Q', the rook — as 'R', the bishop — as'B', the knight — as 'N', the pawn — as 'P', the king — as 'K'.       
        //    the queen's weight is 9,
        //    the rook's weight is 5,
        //    the bishop's weight is 3,
        //    the knight's weight is 3,
        //    the pawn's weight is 1,
        //    the king's weight isn't considered in evaluating position. 
        w.put('Q', 9);
        w.put('R', 5);
        w.put('B', 3);
        w.put('N', 3);
        w.put('P', 1);
        w.put('K', 0);
        
        // 'q', 'r', 'b', 'n', 'p', 'k',
        Map<Character, Integer> b = new HashMap<>();
        b.put('q', 9);
        b.put('r', 5);
        b.put('b', 3);
        b.put('n', 3);
        b.put('p', 1);
        b.put('k', 0);
        
        int wsum = 0;
        int bsum = 0;
        
        for (int i = 0; i < 8; i++) {
            String line = sc.next();
            for (int j = 0; j < 8; j++) {
                char v = line.charAt(j);
                if (v != '.'){
                    if (w.containsKey(v)){
                        wsum += w.get(v);
                    } else if (b.containsKey(v)){
                        bsum += b.get(v);
                    }
                }
            }
        }
        
        if (wsum == bsum){
            System.out.println("Draw");
        } else if (wsum > bsum){
            System.out.println("White");
        } else {
            System.out.println("Black");
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