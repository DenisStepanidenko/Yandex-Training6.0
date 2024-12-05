package lesson1.problemB;

import java.io.*;
import java.util.StringTokenizer;


public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int A = input.nextInt();
        int B = input.nextInt();
        int C = input.nextInt();
        int D = input.nextInt();

        // A -> C
        // B -> D

        // Рассмотрим случай, когда что-то равняется нулю
        if (A == 0) {
            System.out.println(1 + " " + (C + 1));
            System.exit(0);
        }

        if (B == 0) {
            System.out.println(1 + " " + (D + 1));
            System.exit(0);
        }

        if (C == 0) {
            System.out.println((A + 1) + " " + 1);
            System.exit(0);
        }

        if (D == 0) {
            System.out.println((B + 1) + " " + 1);
            System.exit(0);
        }

        // теперь у нас нет нулевых значений
        // берём комплект синего
        int ansA = B + 1 + D + 1;
        int MA = B + 1;
        int NA = D + 1;


        // берём комплект синего
        int ansB = A + 1 + C + 1;
        int MB = A + 1;
        int NB = C + 1;


        // теперь вдруг из какой-то кучи мы можем взять сразу все цвета
        // из 1 кучи берём все цвета
        int ansFirst = Math.max(A, B) + 1 + 1;
        int MFirst = Math.max(A, B) + 1;
        int NFirst = 1;

        // из второй куч берём все цвета
        int ansSecond = Math.max(C, D) + 1 + 1;
        int MSecond = 1;
        int NSecond = Math.max(C, D) + 1;

        int min = Math.min(Math.min(ansA, ansB), Math.min(ansFirst, ansSecond));
        if (min == ansA) {
            System.out.println(MA + " " + NA);
        } else if (min == ansB) {
            System.out.println(MB + " " + NB);
        } else if (min == ansFirst) {
            System.out.println(MFirst + " " + NFirst);
        } else {
            System.out.println(MSecond + " " + NSecond);
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
