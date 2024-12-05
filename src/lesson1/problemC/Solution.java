package lesson1.problemC;


import java.io.*;
import java.util.*;


public class Solution {
    static Reader input = new Reader();

    public static void main(String[] args) {
        int n = input.nextInt();

        List<String> matrix = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String current = input.nextLine();
            matrix.add(current);
        }

        List<Character[]> newRow = new ArrayList<>();

        // сжимаем строки, от пары одинаковых строк оставляем только одну

        Stack<String> saveLine = new Stack<>();
        for (int i = 0; i < matrix.size(); i++) {
            String current = matrix.get(i);

            if (saveLine.isEmpty()) {
                boolean allStars = allStarts(current);

                if (!allStars) {
                    saveLine.add(current);
                }
            } else {
                if (!saveLine.peek().equals(current)) {
                    saveLine.add(current);
                }
            }
        }

        // проверка на последний элемент
        if (!saveLine.isEmpty()) {
            String current = saveLine.peek();
            boolean allStars = allStarts(current);

            if (allStars) {
                saveLine.pop();
            }
        }

        if (saveLine.size() == 0) {
            System.out.println("X");
            System.exit(0);
        }

        matrix = new ArrayList<>();

        for (int i = 0; i < saveLine.size(); i++) {
            matrix.add(saveLine.get(i));
        }

        var matrixReverse = transporant(matrix);

        // сжимаем столбцы, от пары одинаковых столбцов оставляем только один
        saveLine = new Stack<>();
        for (int i = 0; i < matrixReverse.size(); i++) {
            String current = matrixReverse.get(i);

            if (saveLine.isEmpty()) {
                boolean allStars = allStarts(current);

                if (!allStars) {
                    saveLine.add(current);
                }
            } else {
                if (!saveLine.peek().equals(current)) {
                    saveLine.add(current);
                }
            }
        }

        // проверка на последний элемент
        if (!saveLine.isEmpty()) {
            String current = saveLine.peek();
            boolean allStars = allStarts(current);

            if (allStars) {
                saveLine.pop();
            }
        }

        if (saveLine.size() == 0) {
            System.out.println("X");
            System.exit(0);
        }

        matrix = new ArrayList<>();

        for (int i = 0; i < saveLine.size(); i++) {
            matrix.add(saveLine.get(i));
        }

        matrix = transporant(matrix);

        List<String> I = Arrays.asList("#");
        List<String> O = Arrays.asList("###", "#.#", "###");
        List<String> C = Arrays.asList("##", "#.", "##");
        List<String> L = Arrays.asList("#.", "##");
        List<String> H = Arrays.asList("#.#", "###", "#.#");
        List<String> P = Arrays.asList("###", "#.#", "###", "#..");


        if(equalsForMatrix(matrix,I)){
            System.out.println("I");
        }
        else if(equalsForMatrix(matrix,O)){
            System.out.println("O");
        }
        else if(equalsForMatrix(matrix,C)){
            System.out.println("C");
        }
        else if(equalsForMatrix(matrix,L)){
            System.out.println("L");
        }
        else if(equalsForMatrix(matrix,H)){
            System.out.println("H");
        }
        else if(equalsForMatrix(matrix,P)){
            System.out.println("P");
        }
        else{
            System.out.println("X");
        }

    }

    static boolean equalsForMatrix(List<String> ourMatrix, List<String> letter) {
        if (ourMatrix.size() != letter.size()) {
            return false;
        }

        for (int i = 0; i < ourMatrix.size(); i++) {
            if (!Objects.equals(ourMatrix.get(i), letter.get(i))) {
                return false;
            }
        }

        return true;
    }


    static boolean allStarts(String current) {
        int count = 0;

        for (int i = 0; i < current.length(); i++) {
            if (current.charAt(i) == '.') {
                count++;
            }
        }

        return count == current.length();
    }

    // транспонирование
    static List<String> transporant(List<String> matrix) {

        List<String> newMatrix = new ArrayList<>();

        for (int i = 0; i < matrix.get(0).length(); i++) {
            StringBuilder currentRow = new StringBuilder();
            for (int j = 0; j < matrix.size(); j++) {
                currentRow.append(matrix.get(j).charAt(i));
            }
            newMatrix.add(currentRow.toString());
        }

        return newMatrix;
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

