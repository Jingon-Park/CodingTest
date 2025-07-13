package group_study.week_5;

import java.util.LinkedList;
import java.util.Queue;

public class Num3 {
    static class Solution {
        int ySize = 0;
        int xSize = 0;
        boolean[][] charBoard;
        int[] mvX = {1, -1, 0, 0};
        int[] mvY = {0, 0, 1, -1};
        public int solution(String[] board) {
            int xPosition = 0; int yPosition = 0;

            xSize = board.length;
            ySize = board[0].length();
            charBoard = new boolean[xSize][ySize];

            //bfs 큐
            Queue<int[]> q = new LinkedList<>();

            for (int x = 0; x < board.length; x++) {
                String yLine = board[x];
                for (int y = 0; y < yLine.length(); y++) {
                    if (yLine.charAt(y) == 'R') {
                        xPosition = x;
                        yPosition = y;
                    }
                }
            }

            //현재 위치와 level
            q.add(new int[]{xPosition, yPosition, 0});
            charBoard[xPosition][yPosition] = true;


            while (!q.isEmpty()) {
                int[] current = q.poll();
                //현재 위치가 'G'이면 level로 응답
                if (board[current[0]].charAt(current[1]) == 'G') {
                    return current[2];
                }

                for (int i = 0; i < 4; i++) {
                    int nextX = current[0];
                    int nextY = current[1];
                    while (true) {
                        int targetX = nextX + mvX[i];
                        int targetY = nextY + mvY[i];
                        if (targetX >= 0 && targetX < xSize && targetY >= 0 && targetY < ySize
                            && board[targetX].charAt(targetY) != 'D') {
                            nextX = targetX;
                            nextY = targetY;
                        } else {
                            break;
                        }
                    }
                    if (!charBoard[nextX][nextY]) {
                        charBoard[nextX][nextY] = true;
                        q.add(new int[]{nextX, nextY, current[2] + 1});
                    }
                }
            }
            return -1;
        }
    }
    public static void main(String[] args) {

        String[] board = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
        Solution solution = new Solution();
        int result = solution.solution(board);
        System.out.println(result);

    }

}
