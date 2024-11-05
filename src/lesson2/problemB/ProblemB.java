package lesson2.problemB;

import java.io.*;
import java.util.StringTokenizer;

public class ProblemB {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        long k = input.nextLong();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }

        int[] prefixSum = makePrefixSum(arr);

        if (n == 1) {
            if (arr[0] == k) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            System.exit(0);
        }

        int right = 0;
        int answer = 0;

        for (int i = 0; i < prefixSum.length; i++) {
            while (right < prefixSum.length && (prefixSum[right] - prefixSum[i] < k)) {
                right++;
            }

            if (right == prefixSum.length) {
                break;
            }

            if (prefixSum[right] - prefixSum[i] == k) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    public static int[] makePrefixSum(int[] arr) {
        int[] prefixSum = new int[arr.length + 1];
        prefixSum[0] = 0;

        for (int i = 1; i < arr.length + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + arr[i - 1];
        }

        return prefixSum;
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

