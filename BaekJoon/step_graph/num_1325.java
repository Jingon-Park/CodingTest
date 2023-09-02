package step_graph;

import java.io.*;
import java.util.*;

public class num_1325 {

    static int computer;
    static int input;

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    static boolean[] checker;

    static int[] number;

    static int MAX = Integer.MIN_VALUE;

    static void initGraph() {
        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        computer = Integer.parseInt(st.nextToken());
        input = Integer.parseInt(st.nextToken());

        number = new int[computer + 1];
        checker = new boolean[computer + 1];

        initGraph();

        for (int i = 0; i < input; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            graph.get(y).add(x);

        }

        for (int i = 1; i <= computer; i++) {
            int linkedComputer = bfs(i);
            number[i] = linkedComputer;
            MAX = Math.max(MAX, linkedComputer);
            checker = new boolean[computer + 1];
        }


        for (int i = 1; i <= computer; i++) {
            if (number[i] == MAX) {
                bw.write(i + " ");

            }
        }

        bw.flush();
        bw.close();


    }

    static int bfs(int start) {

        int linkedComputerNum = 1;
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        checker[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            List<Integer> linked = graph.get(node);

            for (Integer target : linked) {
                if (!checker[target]) {
                    checker[target] = true;
                    queue.add(target);
                    linkedComputerNum++;
                }
            }

        }
        return linkedComputerNum;
    }
}
