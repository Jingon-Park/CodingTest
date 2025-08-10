package group_study.week_9;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Num3 {
    static class Solution {

        class Position{
            public int x;
            public int y;
            public boolean visited;

            public Position(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                Position target = (Position) obj;
                return this.x == target.x && this.y == target.y;
            }

            @Override
            public String toString() {
                return "Position{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
            }
        }


        int[] moveX = {1, 0, -1, 0};
        int[] moveY = {0, 1, 0, -1};

        List<List<Position>> emptyGroup = new ArrayList<>();
        List<List<Position>> puzzleGroup = new ArrayList<>();
        public int solution(int[][] game_board, int[][] table) {
            int answer = 0;

            boolean[][] visitedForBoard = new boolean[game_board.length][game_board[0].length];
            boolean[][] visitedForTable = new boolean[table.length][table[0].length];

            for (int x = 0; x < game_board.length; x++) {
                for (int y = 0; y < game_board[x].length; y++) {
                    getLinkedPosition(x, y, game_board, 0, emptyGroup, visitedForBoard);
                    getLinkedPosition(x, y, table, 1, puzzleGroup, visitedForTable);
                }
            }

            for (List<Position> group : emptyGroup) {
                normalize(group);
            }

            for (List<Position> group : puzzleGroup) {
                normalize(group);
            }


            for (List<Position> emptyMember : emptyGroup) {
                for (int i = 0; i < puzzleGroup.size(); i++) {
                    boolean isSame = false;
                    List<Position> puzzleMember = puzzleGroup.get(i);

                    if (emptyMember.size() == puzzleMember.size()) {
                        for (int j = 0; j < 4; j++) {
                            rotate(puzzleMember);
                            if (isSame(emptyMember, puzzleMember)) {
                                answer += puzzleMember.size();
                                puzzleGroup.remove(i);
                                isSame = true;
                                break;
                            }
                        }
                    }
                    if (isSame) {
                        break;
                    }
                }
            }
            return answer;
        }

        public boolean isSame(List<Position> empty, List<Position> puzzle) {
            if (empty.size() != puzzle.size()) return false;

            // 좌표를 (x, y) 순으로 정렬하여 비교
            for (Position position : puzzle) {
                if(!empty.contains(position)) {
                    return false;
                }
            }

            return true;

        }

        public void rotate(List<Position> group) {

            for (Position member : group) {
                int tempX = member.x;
                int tempY = member.y;

                member.x = tempY;
                member.y = tempX * -1;

            }

            normalize(group);
        }

        public void normalize(List<Position> group) {

            int minX = Integer.MAX_VALUE;
            int minY = Integer.MAX_VALUE;

            for (Position position : group) {
                minX = Math.min(minX, position.x);
                minY = Math.min(minY, position.y);
            }

            for (Position position : group) {
                position.x -= minX;
                position.y -= minY;
            }
        }



        public void getLinkedPosition(int startX, int startY, int[][] board, int target, List<List<Position>> targetGroup, boolean[][] visited) {

            if (visited[startX][startY] || board[startX][startY] != target) {
                return;
            }
            Queue<Position> queue = new LinkedList<>();
            queue.add(new Position(startX, startY));
            visited[startX][startY] = true;
            List<Position> group = new ArrayList<>();

            while (!queue.isEmpty()) {
                Position current = queue.poll();
                if (board[current.x][current.y] == target) {
                    group.add(current);
                    for (int i = 0; i < 4; i++) {
                        int nextX = current.x + moveX[i];
                        int nextY = current.y + moveY[i];
                        if (nextX >= 0 && nextX < board.length && nextY >= 0 && nextY < board.length
                            && !visited[nextX][nextY] && board[nextX][nextY] == target) {
                            queue.add(new Position(nextX, nextY));
                            visited[nextX][nextY] = true;
                        }
                    }
                }
            }
            targetGroup.add(group);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] gameBoard = {{1, 1, 0, 0, 1, 0}, {0, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 0, 1},
            {1, 1, 0, 1, 1, 1}, {1, 0, 0, 0, 1, 0}, {0, 1, 1, 1, 0, 0}};

        int[][] table = {{1, 0, 0, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 0, 1, 1}, {0, 0, 1, 0, 0, 0},
            {1, 1, 0, 1, 1, 0}, {0, 1, 0, 0, 0, 0}};

        int result = solution.solution(gameBoard, table);
        System.out.println(result);
    }

}
