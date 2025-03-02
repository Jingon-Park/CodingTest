package skill_check.second;

public class Level_2_2 {
    static class Solution {
        public int[][] solution(int[][] arr1, int[][] arr2) {
            int[][] answer = new int[arr1.length][arr2[0].length];

            int repeat = arr2.length;


            for (int r = 0; r < answer.length; r++) {
                for (int c = 0; c < answer[0].length; c++) {
                    int num = 0;
                    for (int i = 0; i < repeat; i++) {
                        num = num + arr1[r][i] * arr2[i][c];
                    }
                    answer[r][c] = num;
                }
            }
            return answer;
        }
    }

    public static void main(String[] args) {

        int[][] arr1 = {{1, 4}, {3, 2}, {4, 1}};
        int[][] arr2 = {{3, 3}, {3, 3}};

        Solution solution = new Solution();
        int[][] result = solution.solution(arr1, arr2);

        for (int[] row : result) {
            for (int col : row) {
                System.out.print(col);
            }
            System.out.println("");
        }

    }
}
