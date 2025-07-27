package group_study.week_7;

import java.util.LinkedList;
import java.util.Queue;

public class Num2 {

    static class Solution {

//        static int[] mX = {-1, 0, 0, 1};
//        static int[] mY = {0, -1, 1, 0};

        static int[] moveN = {1, 0, 0, -1};
        static int[] moveM = {0, -1, 1, 0};

        static int nSize;
        static int mSize;

        public String solution(int n, int m, int x, int y, int r, int c, int k) {
            String answer = "";
            nSize = n;
            mSize = m;

            return bfs(x, y, r, c, 0, k);

        }

        public String bfs(int x, int y, int r, int c, int lv, int k) {

            Queue<String[]> queue = new LinkedList<>();

            queue.add(new String[]{Integer.toString(x), Integer.toString(y), Integer.toString(lv), ""});

            while (!queue.isEmpty()) {
                String[] current = queue.poll();
                int currentLv = Integer.parseInt(current[2]);

                if (currentLv <= k) {
                    int currentX = Integer.parseInt(current[0]);
                    int currentY = Integer.parseInt(current[1]);
                    if (currentLv == k && currentX == r && currentY == c) {
                        return current[3];
                    }

                    for (int i = 0; i < 4; i++) {
                        int nextX = Integer.parseInt(current[0]) + moveN[i];
                        int nextY = Integer.parseInt(current[1]) + moveM[i];
                        if (nextX > 0 && nextX <= nSize && nextY > 0 && nextY <= mSize) {
                            String addString;
                            if (i == 0) {
                                addString = "d";
                            } else if (i == 1) {
                                addString = "l";
                            } else if (i == 2) {
                                addString = "r";
                            } else {
                                addString = "u";
                            }
                            queue.add(new String[]{Integer.toString(nextX), Integer.toString(nextY),
                                Integer.toString(Integer.parseInt(current[2]) + 1),
                                current[3] + addString});
                        }
                    }
                }
            }

            return "impossible";
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String result = solution.solution(3, 4, 2, 3, 3, 1, 5);
        System.out.println(result);
    }

}
