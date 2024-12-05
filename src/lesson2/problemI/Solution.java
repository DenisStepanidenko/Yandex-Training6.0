package lesson2.problemI;


import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {

        int n = input.nextInt();

        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            a[i] = x;
        }

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            b[i] = x;
        }

        int[] p = new int[n];

        for (int i = 0; i < n; i++) {
            int x = input.nextInt();
            p[i] = x;
        }

        Algos[] aResult = new Algos[n];
        Algos[] bResult = new Algos[n];


        for (int i = 0; i < n; i++) {
            Algos algos = new Algos(a[i], b[i], i + 1);

            aResult[i] = algos;
            bResult[i] = algos;
        }

        Arrays.sort(aResult, new AlgosComparatorA());
        Arrays.sort(bResult, new AlgosComparatorB());

        int aIndex = 0;
        int bIndex = 0;

        StringBuilder ans = new StringBuilder();


        for (int i = 0; i < n; i++) {
            if (p[i] == 0) {
                // выбираем с макс a

                while (aResult[aIndex].isPassed()) {
                    aIndex++;
                }

                ans.append(aResult[aIndex].getIndex()).append(" ");
                aResult[aIndex].setPassed(true);
                aIndex++;

            } else {
                // выбираем с макс b

                while (bResult[bIndex].isPassed()) {
                    bIndex++;
                }

                ans.append(bResult[bIndex].getIndex()).append(" ");
                bResult[bIndex].setPassed(true);
                bIndex++;
            }
        }

        System.out.println(ans);


    }

    static class AlgosComparatorB implements Comparator<Algos> {

        @Override
        public int compare(Algos o1, Algos o2) {
            if (o1.getB() > o2.getB()) {
                return -1;
            } else if (o1.getB() < o2.getB()) {
                return 1;
            } else {
                if (o1.getA() > o2.getA()) {
                    return -1;
                } else if (o1.getA() < o2.getA()) {
                    return 1;
                } else {
                    if (o1.getIndex() < o2.getIndex()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        }
    }

    static class AlgosComparatorA implements Comparator<Algos> {

        @Override
        public int compare(Algos o1, Algos o2) {
            if (o1.getA() > o2.getA()) {
                return -1;
            } else if (o1.getA() < o2.getA()) {
                return 1;
            } else {
                if (o1.getB() > o2.getB()) {
                    return -1;
                } else if (o1.getB() < o2.getB()) {
                    return 1;
                } else {
                    if (o1.getIndex() < o2.getIndex()) {
                        return -1;
                    } else {
                        return 1;
                    }
                }
            }
        }


    }

    static class Algos {
        public int a;
        public int b;
        public int index;
        boolean isPassed = false;

        public Algos(int a, int b, int index) {
            this.a = a;
            this.b = b;
            this.index = index;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public boolean isPassed() {
            return isPassed;
        }

        public void setPassed(boolean passed) {
            this.isPassed = passed;
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
