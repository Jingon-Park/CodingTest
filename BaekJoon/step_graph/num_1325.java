package step_graph;

import java.io.*;
import java.util.*;

public class num_1325 {


    public static ArrayList<Integer>[] graph;

    public static int computer;

    public static int[] number;


    public static void main(String[] args) throws IOException {
        int MAX = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] str = br.readLine().split(" ");
        computer = Integer.parseInt(str[0]);
        int input = Integer.parseInt(str[1]);

        graph = new ArrayList[computer + 1];

        for (int i = 0; i <= computer; i++) {
            graph[i] = new ArrayList<Integer>();

        }

        for (int i = 0; i < input; i++) {
            String[] xy = br.readLine().split(" ");
            int x = Integer.parseInt(xy[0]);
            int y = Integer.parseInt(xy[1]);

            graph[x].add(y);



        }

        number = new int[computer + 1];

        for (int i = 1; i <= computer; i++) {
            bfs(i);
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 1; i <= computer; i++) {
            if (number[i] > MAX) {
                MAX = number[i];
                result.clear();
                result.add(i);
            } else if (number[i] == MAX) {
                result.add(i);
            }
        }

        for (int num : result) {
            bw.write(num + " ");
        }

        bw.flush();
        bw.close();


    }

    static void bfs(int start) {

        boolean[] checker = new boolean[computer + 1];
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        checker[start] = true;

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (Integer target : graph[node]) {
                if (!checker[target]) {
                    checker[target] = true;
                    queue.add(target);
                    number[target]++;
                }
            }

        }
    }
}
