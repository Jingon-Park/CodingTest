package step_graph;

import java.io.*;

public class num_1012 {


    static int[][] graph;
    static boolean[][] checker;
    static int counter;

    static int xSize;
    static int ySize;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCaseNum = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCaseNum; i++) {
            String line = br.readLine();
            String[] lineSplit = line.split(" ");
            xSize = Integer.parseInt(lineSplit[0]);
            ySize = Integer.parseInt(lineSplit[1]);
            int itemNum = Integer.parseInt(lineSplit[2]);

            graph = new int[xSize][ySize];
            checker = new boolean[xSize][ySize];


            for (int j = 0; j < itemNum; j++) {
                String position = br.readLine();
                String[] positionSplit = position.split(" ");
                graph[Integer.parseInt(positionSplit[0])][Integer.parseInt(positionSplit[1])] = 1;

            }
            for (int x = 0; x < xSize; x++) {
                for (int y = 0; y < ySize; y++) {
                    if (graph[x][y] == 1 && !checker[x][y]) {
                        dfs(x, y);
                        counter++;
                    }
                }
            }
            System.out.println(counter);
            counter = 0;
        }


    }

    static void dfs(int x, int y) {
        if (graph[x][y] == 1 && !checker[x][y]) {
            checker[x][y] = true;
            if (y - 1 >= 0 && graph[x][y - 1] == 1 && !checker[x][y - 1]) {
                dfs(x, y - 1);
            }

            if (y + 1 < ySize && graph[x][y + 1] == 1 && !checker[x][y + 1]) {
                dfs(x, y + 1);
            }

            if (x - 1 >= 0 && graph[x - 1][y] == 1 && !checker[x - 1][y]) {
                dfs(x - 1, y);
            }

            if (x + 1 < xSize && graph[x + 1][y] == 1 && !checker[x + 1][y]) {
                dfs(x + 1, y);
            }


        }else{
            return;
        }
    }
}
