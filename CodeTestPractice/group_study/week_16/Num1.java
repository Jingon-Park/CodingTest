package group_study.week_16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 토마토
 * https://www.acmicpc.net/problem/7569
 */
public class Num1 {

    static int result = 0;
    static int M;
    static int N;
    static int H;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        M = Integer.parseInt(input[0]);
        N = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        int[][][] box = new int[M][N][H];
        int zeros = 0;

        Queue<int[]> positions = new LinkedList<>();

        for (int h = 0; h < H; h++) {
            for (int y = 0; y < N; y++) {
                String[] line = br.readLine().split(" ");

                for (int x = 0; x < M; x++) {
                    int tomato = Integer.parseInt(line[x]);
                    if (tomato == 1) {
                        positions.add(new int[]{x, y, h, 0});
                    }

                    if (tomato == 0) {
                        zeros++;
                    }
                    box[x][y][h] = tomato;
                }
            }
        }

        if (zeros == 0) {
            System.out.println(result);
            return;
        }

        int[] moveX = {1, -1, 0, 0, 0, 0};
        int[] moveY = {0, 0, 1, -1, 0, 0};
        int[] moveH = {0, 0, 0, 0, 1, -1};

        while (!positions.isEmpty()) {

            int[] current = positions.poll();

            for (int i = 0; i < moveX.length; i++) {
                int nextX = current[0] + moveX[i];
                int nextY = current[1] + moveY[i];
                int nextH = current[2] + moveH[i];

                if (nextX >= 0 && nextX < M && nextY >= 0 && nextY < N && nextH >= 0 && nextH < H) {

                    int next = box[nextX][nextY][nextH];

                    if (next == 0) {
                        box[nextX][nextY][nextH] = 1;
                        positions.add(new int[]{nextX, nextY, nextH, current[3] + 1});

                        zeros--;
                        result = Math.max(result, current[3] + 1);
                    }
                }
            }
        }

        if (zeros > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(result);

    }
}
