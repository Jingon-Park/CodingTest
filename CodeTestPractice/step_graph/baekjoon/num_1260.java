package step_graph.baekjoon;

import java.util.*;
class num_1260 {

    static int N;
    static int M;
    static int V;
    static boolean[][] graph;
    static boolean[] checker;
    static StringBuilder dfsBuilder = new StringBuilder();
    static StringBuilder bfsBuilder = new StringBuilder();

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        V = sc.nextInt();

        graph = new boolean[N + 1][N + 1];
        checker = new boolean[N + 1];

        for(int i = 0; i < M; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            graph[x][y] = graph[y][x] = true;
        }

        dfs(V);
        checker = new boolean[N + 1];
        bfs(V);
        System.out.println(dfsBuilder);
        System.out.println(bfsBuilder);



    }

    public static void dfs(int start){
        if(checker[start]){
            return;
        }
        checker[start] = true;
        dfsBuilder.append(start + " ");

        for(int i = 1; i <= N; i++){
            if(graph[start][i] && !checker[i]){
                dfs(i);
            }
        }
    }

    public static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();

        if (!checker[start]){
            queue.add(start);
            checker[start] = true;
            while (!queue.isEmpty()) {
                int num = queue.poll();
                bfsBuilder.append(num + " ");
                for (int i = 1; i <= N; i++) {
                    if (graph[num][i] && !checker[i]) {
                        queue.add(i);
                        checker[i] = true;
                    }
                }
            }
        }
    }
}