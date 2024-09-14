package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class kthNum {


    static class Solution {

        public int[] solution(int[] array, int[][] commands) {
            int[] answer = new int[commands.length];
            List<Integer> answerList = new ArrayList<>();

            for (int i = 0; i < commands.length; i++) {
                int start = commands[i][0];
                int end = commands[i][1];
                int k = commands[i][2];

                int[] splitedArr = Arrays.copyOfRange(array, start - 1, end);
                Arrays.sort(splitedArr);
                for (int i1 : splitedArr) {
                }

                answer[i] = splitedArr[k - 1];
            }

            return answer;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = {1, 5, 2, 6, 3, 7, 4};

        int[][] ints1 = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        solution.solution(ints, ints1);
    }
}
