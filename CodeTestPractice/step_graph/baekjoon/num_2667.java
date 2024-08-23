package step_graph.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class num_2667 {

    static int size;
    static int[][] graph;
    static boolean[][] checker;

    static List<Integer> counter = new ArrayList<>();
    static int count;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(br.readLine());

        graph = new int[size + 1][size + 1];
        checker = new boolean[size + 1][size + 1];


        for (int i = 1; i <= size; i++) {
            String line = br.readLine();
            for (int j = 0; j < line.length(); j++) {
                char c = line.charAt(j);
                if (c == '1') {
                    graph[i][j + 1] = 1;
                }
            }
        }

        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                dfs(i, j);
                if (count > 0) {
                    counter.add(count);
                }
                count = 0;
            }
        }



        System.out.println(counter.size());

        Collections.sort(counter);
        for (int num : counter) {
            System.out.println(num);
        }




    }

    static void dfs(int x, int y) {
        if (!checker[x][y] && graph[x][y] == 1) {

            checker[x][y] = true;
            count++;
            if (y - 1 > 0 && graph[x][y - 1] == 1 && !checker[x][y - 1]) {
                dfs(x, y - 1);
            }
            if (y + 1 < size + 1 && graph[x][y + 1] == 1 && !checker[x][y + 1]) {
                dfs(x, y + 1);
            }

            if (x - 1 > 0 && graph[x - 1][y] == 1 && !checker[x - 1][y]) {
                dfs(x - 1, y);

            }

            if (x + 1 < size + 1 && graph[x + 1][y] == 1 && !checker[x + 1][y]) {
                dfs(x + 1, y);

            }


        }else{
            return;
        }
    }
}
