package step_graph.baekjoon;

import java.util.*;

public class num_11725 {

    static int node;

    static List<Integer>[] graph;


    static int[] parents;

    static boolean[] checker;

    static void initGraph() {
        for (int i = 1; i <= node; i++) {
            graph[i] = new ArrayList<>();
        }
    }


    /**
     * 인접 행렬로 문제 풀이를 하면 메모리 초과가 발생함
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        node = sc.nextInt();

        graph = new ArrayList[node + 1];
        parents = new int[node + 1];
        checker = new boolean[node + 1];

        initGraph();

        for (int i = 1; i < node; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            graph[x].add(y);
            graph[y].add(x);
        }

        bfs(1);

        for (int i = 2; i < parents.length; i++) {
            System.out.println(parents[i]);
        }



    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList();

        queue.add(start);
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            List<Integer> row = graph[poll];
            for (Integer node : row) {
                if (!checker[node]) {
                    queue.add(node);
                    checker[node] = true;
                    parents[node] = poll;
                }
            }
        }
    }


}
