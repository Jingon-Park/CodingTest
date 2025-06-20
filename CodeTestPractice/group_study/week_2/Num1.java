package group_study.week_2;

import java.util.LinkedList;
import java.util.Queue;

public class Num1 {
    static class Solution {

        public static int counter = 0;
        public static int[] mX = {1, -1, 0, 0};
        public static int[] mY = {0, 0, 1, -1};
        public static char[][] storageChar;
        public static boolean[][] visited;
        public static int xLeng;
        public static int yLeng;
        public int solution(String[] storage, String[] requests) {

            yLeng = storage.length;
            xLeng = storage[0].length();
            storageChar = new char[yLeng][xLeng];

            for(int i = 0; i < storage.length; i++) {
                for (int j = 0; j < storage[i].length(); j++) {
                    storageChar[i][j] = storage[i].charAt(j);
                }
            }

            for (int i = 0; i < requests.length; i++) {
                if (requests[i].length() == 1) {
                    move(requests[i].charAt(0));
                } else {
                    moveFromCrane(requests[i].charAt(0));
                }
            }

            return xLeng * yLeng - counter;
        }

//        private boolean dfs(int x, int y){
//            visited[y][x] = true;
//            for (int i = 0; i < mX.length; i++) {
//                int moveX = x + mX[i];
//                int moveY = y + mY[i];
////                System.out.println("moveX : " + moveY + ", moveY :" + y);
//                if (edgeCheck(moveX, moveY)) {
//                    return true;
//                }
//
//                if (storageChar[moveY][moveX] == ' ' && !visited[moveY][moveX]) {
//                    boolean dfs = dfs(moveX, moveY);
//                    visited[moveY][moveX] = false;
//                    if (dfs) {
//                        return dfs;
//                    }
//                }
//            }
//            return false;
//        }

        private boolean bfs(int x, int y, char[][] storageChar) {
            boolean[][] visited = new boolean[yLeng][xLeng];
            Queue<Integer> xQueue = new LinkedList<>();
            Queue<Integer> yQueue = new LinkedList<>();
            xQueue.add(x);
            yQueue.add(y);
            visited[y][x] = true;
            while (!yQueue.isEmpty()) {
                int targetX = xQueue.poll();
                int targetY = yQueue.poll();
                if (edgeCheck(targetX, targetY)) {
                    return true;
                }

                for (int i = 0; i < mX.length; i++) {
                    int nextX = targetX + mX[i];
                    int nextY = targetY + mY[i];
                    if (storageChar[nextY][nextX] == ' ' && !visited[nextY][nextX]) {
                        xQueue.add(nextX);
                        yQueue.add(nextY);
                        visited[nextY][nextX] = true;
                    }
                }

            }
            return false;
        }

        private boolean edgeCheck(int x, int y) {
            if (x <= 0 || x >= xLeng - 1 || y <= 0 || y >= yLeng - 1) {
                return true;
            }
            return false;
        }

        public void move(char target) {

            char[][] temp = new char[yLeng][];

            for (int i = 0; i < yLeng; i++) {
                temp[i] = new char[storageChar[i].length];
                System.arraycopy(storageChar[i], 0, temp[i], 0, storageChar[i].length);
            }

            for(int y = 0; y < yLeng; y++) {
                for(int x = 0; x < xLeng; x++) {
                    if(temp[y][x] == target) {
                        if (bfs(x, y, temp)) {
                            storageChar[y][x] = ' ';
                            counter++;
                        }
                    }
                }
            }

        }

        public void moveFromCrane(char target) {
            for(int y = 0; y < yLeng; y++) {
                for(int x = 0; x < xLeng; x++) {
                    if (storageChar[y][x] == target) {
                        storageChar[y][x] = ' ';
                        counter++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        String[] storages = {"AZWQY", "CAABX", "BBDDA", "ACACA"};
        String[] reqs = {"A", "BB", "A"};
        Solution solution = new Solution();
        int result = solution.solution(storages, reqs);
        System.out.println(result);


    }

}
