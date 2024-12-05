package lesson2.problemE;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            arr[i] = x;
        }

        Arrays.sort(arr);

        if (n == 1) {
            System.out.println(arr[0]);
            System.exit(0);
        }

        int k = 0;
        int chet = 0;
        int count = 0;
        int index;

        if ((arr.length % 2) == 0) {
            if (arr[arr.length / 2] == arr[(arr.length / 2) - 1]) {
                index = (arr.length / 2) - 1;
            } else if (arr[arr.length / 2] > arr[(arr.length / 2) - 1]) {
                index = (arr.length / 2) - 1;
            } else {
                index = arr.length / 2;
            }
        } else {
            chet = 1;
            index = arr.length / 2;
        }

        while (count < n) {
            System.out.println(arr[index]);
            count++;
            k++;
            if (count == n) {
                break;
            }

            if (chet == 0) {
                index += k;
                chet = 1;

            } else {
                if (arr[index - k] == arr[index + 1]) {
                    index = index - k;
                } else if (arr[index - k] > arr[index + 1]) {
                    index = index + 1;
                } else {
                    index = index - k;
                }

                chet = 0;
            }
        }

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


