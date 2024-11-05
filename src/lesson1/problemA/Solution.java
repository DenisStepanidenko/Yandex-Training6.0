package lesson1.problemA;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int x1 = input.nextInt();
        int y1 = input.nextInt();
        int x2 = input.nextInt();
        int y2 = input.nextInt();

        int x = input.nextInt();
        int y = input.nextInt();

        // нужно узнать сторону квадрата
        int side = 0;

        if (x1 * x2 < 0) {
            side = Math.abs(x1) + x2;
        } else if (x1 * x2 > 0) {
            side = x2 - x1;
        } else if (x2 == 0) {
            side = Math.abs(x1);
        } else if (x1 == 0) {
            side = x2;
        }

        int y4 = y2;
        int y3 = y1;


        // будем проверять квадрат расстояния

        int NW = (int) (Math.pow(x - x1, 2) + Math.pow(y - y4, 2));
        int NE = (int) (Math.pow(x - x2, 2) + Math.pow(y - y2, 2));
        int SW = (int) (Math.pow(x - x1, 2) + Math.pow(y - y1, 2));
        int SE = (int) (Math.pow(x - x2, 2) + Math.pow(y - y3, 2));


        int N = 0;

        if (y * y4 > 0) {
            N = (int) Math.pow(Math.abs(y - y4), 2);
        } else if (y * y4 < 0) {
            N = (int) Math.pow(Math.abs(y) + Math.abs(y4), 2);
        } else if (y4 == 0) {
            N = (int) Math.pow(Math.abs(y), 2);
        } else if (y == 0) {
            N = (int) Math.pow(Math.abs(y4), 2);
        }

        int W = 0;
        if (x * x1 > 0) {
            W = (int) Math.pow(Math.abs(x - x1), 2);
        } else if (x * x1 < 0) {
            W = (int) Math.pow(Math.abs(x) + Math.abs(x1), 2);
        } else if (x == 0) {
            W = (int) Math.pow(Math.abs(x1), 2);
        } else if (x1 == 0) {
            W = (int) Math.pow(Math.abs(x), 2);
        }

        int E = 0;
        if (x * x2 > 0) {
            E = (int) Math.pow(Math.abs(x - x2), 2);
        } else if (x * x2 < 0) {
            E = (int) Math.pow(Math.abs(x) + Math.abs(x2), 2);
        } else if (x == 0) {
            E = (int) Math.pow(Math.abs(x2), 2);
        } else if (x2 == 0) {
            E = (int) Math.pow(Math.abs(x), 2);
        }

        int S = 0;
        if (y * y3 > 0) {
            S = (int) Math.pow(Math.abs(y - y3), 2);
        } else if (y * y3 < 0) {
            S = (int) Math.pow(Math.abs(y) + Math.abs(y3), 2);
        } else if (y == 0) {
            S = (int) Math.pow(Math.abs(y3), 2);
        } else if (y3 == 0) {
            S = (int) Math.pow(Math.abs(y), 2);
        }

        if (!(y >= y1 && y <= y4) || y == y1 || y == y4) {
            W = Integer.MAX_VALUE;
            E = Integer.MAX_VALUE;
        }
        if (!(x >= x1 && x <= x2) || x == x1 || x == x2) {
            N = Integer.MAX_VALUE;
            S = Integer.MAX_VALUE;
        }

        Map<Integer, String> answers = new HashMap<>();
        answers.put(NW, "NW");
        answers.put(NE, "NE");
        answers.put(SW, "SW");
        answers.put(SE, "SE");
        answers.put(N, "N");
        answers.put(W, "W");
        answers.put(E, "E");
        answers.put(S, "S");





        int max = findMax(NW, NE, SW, SE, N, W, E, S);

        System.out.println(answers.get(max));

    }

    public static int findMax(int... numbers) {
        return Arrays.stream(numbers).min().getAsInt();
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

