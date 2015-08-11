package codeforces.brugmar.codeforces.div2.C;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class CR296_glass_carving {

    public static void main(String... args) throws IOException {
        MyScanner sc = new MyScanner();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int n = sc.nextInt();

        TreeSet<Integer> hLines = new TreeSet<>();
        CountMap<Integer> hDist = new CountMap<>();
        hLines.add(0);
        hLines.add(h);
        hDist.add(h);

        TreeSet<Integer> wLines = new TreeSet<>();
        CountMap<Integer> wDist = new CountMap<>();
        wLines.add(0);
        wLines.add(w);
        wDist.add(w);

        for (int i = 0; i < n; i++) {
            String op = sc.next();
            int val = sc.nextInt();
            switch (op) {
                case "H":
                    int hFloor = hLines.floor(val);
                    int hCeil = hLines.ceiling(val);
                    hLines.add(val);
                    hDist.remove(hCeil - hFloor);
                    hDist.add(val - hFloor);
                    hDist.add(hCeil - val);
                    break;
                case "V":
                    int wFloor = wLines.floor(val);
                    int wCeil = wLines.ceiling(val);
                    wLines.add(val);
                    wDist.remove(wCeil - wFloor);
                    wDist.add(val - wFloor);
                    wDist.add(wCeil - val);
                    break;
            }
            int maxH = hDist.max();
            int maxW = wDist.max();
            System.out.println(1L * maxH * maxW);
        }
    }

    static class CountMap<T> {

        TreeMap<T, Integer> map = new TreeMap<>();

        public void add(T obj) {
            Integer count = map.get(obj);
            if (count == null) {
                count = 0;
            }
            map.put(obj, count + 1);
        }

        public void remove(T obj) {
            Integer count = map.get(obj);
            if (count == 1) {
                map.remove(obj);
            } else if (count != null) {
                map.put(obj, --count);
            }
        }
        
        public T max(){
            return map.lastKey();
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
