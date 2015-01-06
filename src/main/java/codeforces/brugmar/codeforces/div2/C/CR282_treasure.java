package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CR282_treasure {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        String txt = sc.next();
        int lCount = 0;
        int hCount = 0;
        if (!lastPartIsCorrect(txt)) {
            System.out.println("-1");
            return;
        }
        for (int i = 0; i < txt.length(); i++) {
            char ch = txt.charAt(i);

            switch (ch) {
                case '(':
                    lCount++;
                    break;
                case '#':
                    hCount++;
                case ')': {
                    if (lCount > 0) {
                        lCount--;
                    } else {
                        System.out.println("-1");
                        return;
                    }
                    break;
                }
            }
        }

        for (int i = 0; i < hCount - 1; i++) {
            System.out.println("1");
        }
        System.out.println(lCount + 1);
    }

    private static boolean lastPartIsCorrect(String txt) {
        int lasHash = txt.length()-1;
        while (txt.charAt(lasHash) != '#'){
            lasHash--;
        }
        
        int count = 0;
        for (int i=lasHash+1; i < txt.length(); i++){
            count += (txt.charAt(i) == '(') ? 1 : -1;
            count = Math.max(0, count);
        }
        return count == 0;
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
