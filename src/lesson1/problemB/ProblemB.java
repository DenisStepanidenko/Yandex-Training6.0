package lesson1.problemB;

import java.io.*;
import java.util.StringTokenizer;


public class ProblemB {
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
        if(min == ansA){
            System.out.println(MA + " " + NA);
        }
        else if(min == ansB){
            System.out.println(MB + " " + NB);
        }
        else if(min == ansFirst){
            System.out.println(MFirst + " " + NFirst);
        }
        else{
            System.out.println(MSecond + " " + NSecond);
        }
//        // Пусть сначала мы вытащили майку цвета A
//
//        boolean flagA = true;
//        int ansA = 0;
//        int MA = 0;
//        int NA = 0;
//        if (A != 0) {
//            MA = B + 1;
//            if (C != 0) {
//                NA = D + 1;
//                ansA = MA + NA;
//            } else {
//                flagA = false;
//            }
//        } else {
//            flagA = false;
//        }
//
//        // Пусть сначала мы вытащили майку цвета B
//        int ansB = 0;
//        int MB = 0;
//        int NB = 0;
//        boolean flagB = true;
//        if (B != 0) {
//            MB = A + 1;
//            if (D != 0) {
//                NB = C + 1;
//                ansB = MB + NB;
//            } else {
//                flagB = false;
//            }
//        } else {
//            flagB = false;
//        }
//
//        // третий вариант
//        // когда мы берём A + B пар носков
//        int ansC = 0;
//        int MC = 0;
//        int NC = 0;
//        if (A == 0) {
//            ansC = B + C + 1;
//            MC = B;
//            NC = C + 1;
//        } else if (B == 0) {
//            ansC = A + D + 1;
//            MC = A;
//            NC = D + 1;
//        } else {
//
//            ansC = Math.min(A, B) + 2;
//            MC = Math.min(A, B) + 1;
//            NC = 1;
//        }
//
//        // четвёртый вариант
//        // когда мы берём C + D пар носков
//        int ansD = 0;
//        int MD = 0;
//        int ND = 0;
//        if (C == 0) {
//            ansD = D + A + 1;
//            MD = A + 1;
//            ND = D;
//        } else if (D == 0) {
//            ansD = C + B + 1;
//            MD = B + 1;
//            ND = C;
//        } else {
//            ansD = Math.min(C, D) + 2;
//            MD = 1;
//            ND = Math.min(C, D) + 1;
//        }
//
//        if (flagA && flagB) {
//            int min = Math.min(Math.min(ansA, ansD), Math.min(ansB, ansC));
//
//            if (min == ansA) {
//                System.out.println(MA + " " + NA);
//            } else if (min == ansB) {
//                System.out.println(MB + " " + NB);
//            } else if (min == ansC) {
//                System.out.println(MC + " " + NC);
//            } else {
//                System.out.println(MD + " " + ND);
//            }
//        } else if (flagA) {
//            int min = Math.min(Math.min(ansA, ansD), ansC);
//            if (min == ansA) {
//                System.out.println(MA + " " + NA);
//            } else if (min == ansC) {
//                System.out.println(MC + " " + NC);
//            } else {
//                System.out.println(MD + " " + ND);
//            }
//
//        } else {
//            int min = Math.min(ansD, Math.min(ansB, ansC));
//            if (min == ansB) {
//                System.out.println(MB + " " + NB);
//            } else if (min == ansC) {
//                System.out.println(MC + " " + NC);
//            } else {
//                System.out.println(MD + " " + ND);
//            }
//
//        }


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
