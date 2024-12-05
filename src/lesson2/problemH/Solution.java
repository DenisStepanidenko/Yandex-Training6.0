package lesson2.problemH;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();

        long[] people = new long[n];

        for (int i = 0; i < n; i++) {
            long x = input.nextLong();
            people[i] = x;
        }

        long[] prefixSumFirst = new long[n];
        prefixSumFirst[0] = 0;

        for (int i = 1; i < n; i++) {
            prefixSumFirst[i] = prefixSumFirst[i - 1] + people[i - 1];
        }

        long[] prefixSumSecond = new long[n];
        prefixSumSecond[0] = 0;
        for (int i = 1; i < n; i++) {
            prefixSumSecond[i] = prefixSumFirst[i] + prefixSumSecond[i - 1];
        }

        long[] suffixSumFirst = new long[n];
        suffixSumFirst[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            suffixSumFirst[i] = suffixSumFirst[i + 1] + people[i + 1];
        }

        long[] suffixSumSecond = new long[n];
        suffixSumSecond[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            suffixSumSecond[i] = suffixSumFirst[i] + suffixSumSecond[i + 1];
        }

        long min = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, prefixSumSecond[i] + suffixSumSecond[i]);
        }
        System.out.println(min);

    }

    static class Reader extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // standard input

        public Reader() {
            this(System.in, System.out);
        }

        public Reader(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // USACO-style file input

        public Reader(String problemName) throws IOException {
            super(problemName + ".out");
            r = new BufferedReader(new FileReader(problemName));
        }

        // returns null if no more input
        String nextLine() {
            String str = "";
            try {
                str = r.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public String next() {
            try {
                while (st == null || !st.hasMoreTokens()) {
                    st = new StringTokenizer(r.readLine());
                }
                return st.nextToken();
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {

            return Long.parseLong(next());
        }
    }
}
