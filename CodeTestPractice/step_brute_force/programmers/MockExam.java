package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 완전 탐색 / 모의 시험
 */
public class MockExam {
    static class Solution {
        public int[] solution(int[] answers) {
            List<Integer> answer = new ArrayList<>();

            int[] pattern1 = {1, 2, 3, 4, 5};
            int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
            int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

            int[] answerNums = {getAnswerNum(pattern1, answers), getAnswerNum(pattern2,answers), getAnswerNum(pattern3, answers)};

            int max = Arrays.stream(answerNums).max().getAsInt();

            for (int i = 0; i < answerNums.length; i++) {
                if (answerNums[i] == max) {
                    answer.add(i + 1);
                }
            }
            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }

    public static int getAnswerNum(int[] pattern, int[] answers) {

        int index = 0;
        int patternIndex = 0;
        int answer = 0;
        while (index < answers.length) {
            if (answers[index] == pattern[patternIndex]) {
                answer++;
            }
            index++;
            patternIndex++;
            if (patternIndex >= pattern.length) {
                patternIndex = 0;
            }
        }

        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] input = {1,2,3,4,5};
        int[] solution1 = solution.solution(input);

        for (int i : solution1) {
            System.out.println("i = " + i);
        }
    }
}
