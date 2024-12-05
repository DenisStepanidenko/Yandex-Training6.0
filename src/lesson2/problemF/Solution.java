package lesson2.problemF;

import java.io.*;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        long module = 1_000_000_007;

        int n = input.nextInt();

        long[] arr = new long[n];
        long allSum = 0;

        for (int i = 0; i < n; i++) {
            long x = input.nextLong();
            allSum = (allSum + x) % module;
            arr[i] = x;
        }

        long[] prefixSum = new long[n + 1];
        prefixSum[0] = 0;

        // префиксные суммы
        for (int i = 1; i < n + 1; i++) {
            prefixSum[i] = (prefixSum[i - 1] + arr[i - 1]) % module;
        }

        // суффиксные суммы
        long[] suffixSum = new long[n + 1];
        suffixSum[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            suffixSum[i] = (suffixSum[i + 1] + arr[i]) % module;
        }

        long answer = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            long addToAns = (((arr[i] * prefixSum[i]) % module) * suffixSum[i + 1]) % module;
            answer = (answer + addToAns) % module;
        }

        System.out.println(answer);


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
