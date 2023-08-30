package step_graph;

import java.util.Scanner;

public class num_2606 {static int number;
    static int count;
    static StringBuilder sb = new StringBuilder();
    static boolean[] checker;
    static boolean[][] network;

    static int result;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        number = sc.nextInt();
        count = sc.nextInt();

        network = new boolean[number + 1][number + 1];
        for (int i = 0; i < count; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            network[x][y] = network[y][x] = true;
        }

        checker = new boolean[number + 1];

        dfs(1);

        System.out.println(result);



    }

    static void dfs(int start) {
        if (start != 1) {
            result++;
        }
        sb.append(start + " ");
        checker[start] = true;

        for (int i = 1; i <= number; i++) {
            if (network[start][i] && !checker[i]) {
                dfs(i);
            }
        }
    }
}
