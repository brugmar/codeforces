package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CR253_borya_and_hanabi {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();

        int[] allCards = new int[10];

        for (int i = 0; i < 5; i++) {
            allCards[i] = i + 1;
        }

        for (int i = 5; i < 10; i++) {
            allCards[i] = (i - 4) << 8;
        }

        int[] countCards = new int[1286];
        int[] tmpCountCards = new int[1286]; 
        Map<Integer, List<Integer>> pos = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String card = sc.next();
            countCards[cardToInt(card)]++;
            for (Integer c : new int[]{letterToInt(card.charAt(0)), card.charAt(1) - '0'}) {
                List<Integer> posList = pos.get(c);
                if (posList == null) {
                    posList = new ArrayList<>();
                    pos.put(c, posList);
                }
                posList.add(i);
            }
        }
        
        int minSol = Integer.MAX_VALUE;
        for (int t = 0; t < 1024; t++) {
            int[] sol = new int[n];
            for (int i = 0; i < countCards.length; i++) {
                tmpCountCards[i] = countCards[i];
            }
            int k = 9;
            int choosen = 0;
            int val = t;
            while (val != 0) {
                int el = val & 1;
                if (el == 1) {
                    int cc = allCards[k];
                    choosen++;
                    if (pos.get(cc) != null) {
                        for (int p : pos.get(cc)) {
                            sol[p] |= cc;
                            int rc = sol[p] & 0xFF;
                            int lc = sol[p] & 0xFF00;
                            if (rc != 0 && lc != 0) {
                                tmpCountCards[sol[p]]--;
                            }

                        }
                    }
                }
                val >>= 1;
                k--;
            }

            int j = 0;
            int unknownElements = 0;
            while (j < n) {
                int rc = sol[j] & 0xFF;
                int lc = sol[j] & 0xFF00;

                if (rc != 0 && lc == 0) {
                    int diffThanZero = 0;
                    int lastInd = -1;
                    for (int i = 1; i <= 5; i++) {
                        int inx = (i << 8) | rc;
                        diffThanZero += Math.min(1, tmpCountCards[inx]);
                        lastInd = (tmpCountCards[inx] > 0) ? inx : lastInd;
                    }
                    if (diffThanZero > 1) {
                        break;
                    } else {
                        tmpCountCards[lastInd]--;
                    }
                } else if (rc == 0 && lc != 0) {
                    int diffThanZero = 0;
                    int lastInd = -1;
                    for (int i = 1; i <= 5; i++) {
                        int inx = lc | i;
                        diffThanZero += Math.min(1, tmpCountCards[inx]);
                        lastInd = (tmpCountCards[inx] > 0) ? inx : lastInd;
                    }
                    if (diffThanZero > 1) {
                        break;
                    } else {
                        tmpCountCards[lastInd]--;
                    }
                } else if (lc == 0 && rc == 0) {
                    unknownElements++;
                }
                j++;
            }
            if (j == n) {
                if (unknownElements > 0){
                    int diffThanZero = 0;
                    int lastInd = -1;
                    for (int i = 1; i <= 5; i++) {
                        for (int p = 1; p <= 5; p++) {
                            int inx = (i << 8) | p;
                            diffThanZero += Math.min(1, tmpCountCards[inx]);
                            lastInd = tmpCountCards[inx] > 0 ? inx : lastInd;
                        }
                    }
                    if (diffThanZero > 1 || tmpCountCards[lastInd] != unknownElements) {
                        continue;
                    }
                }
                minSol = Math.min(minSol, choosen);
            }
        }
        System.out.println(minSol);
    }

    static int cardToInt(String c) {
        return letterToInt(c.charAt(0)) | (c.charAt(1) - '0');
    }

    static int letterToInt(char c) {
        switch (c) {
            //R, G, B, Y, W
            case 'R':
                return 1 << 8;
            case 'G':
                return 2 << 8;
            case 'B':
                return 3 << 8;
            case 'Y':
                return 4 << 8;
            default:
                return 5 << 8;

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
