package step_graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class num_1260 {    static StringBuilder bfs = new StringBuilder();
    static StringBuilder dfs = new StringBuilder();

    static int num;
    static int lineNum;
    static int start;
    static boolean[] checker;
    static boolean[][] graph;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        num = sc.nextInt();
        lineNum = sc.nextInt();

        graph = new boolean[num + 1][num + 1];
        start = sc.nextInt();

        for (int i = 0; i < lineNum; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }
        checker = new boolean[num + 1];
        dfs(start);

        checker = new boolean[num + 1];
        bfs(start);

        System.out.println(dfs.toString());
        System.out.println(bfs.toString());


    }

    static void dfs(int start) {
        if (!checker[start]){
            checker[start] = true;
            dfs.append(start + " ");
        }else{
            return;
        }
        for (int i = 1; i <= num; i++) {
            if (graph[start][i]) {
                dfs(i);
            }
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList();
        queue.add(start);
        checker[start] = true;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            bfs.append(node + " ");
            for (int i = 1; i <= num; i++) {
                if (graph[node][i] && !checker[i]) {
                    queue.add(i);
                    checker[i] = true;
                }
            }
        }
    }
}
