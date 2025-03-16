package programmers;

import java.util.ArrayList;
import java.util.List;

/**
 * 완전 탐색 / 모의 시험
 */
public class MockExam {

    static class Solution {

        int[] num1 = {1, 2, 3, 4, 5};
        int[] num2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] num3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        public int[] solution(int[] answers) {

            List<Integer> answer = new ArrayList<>();
            int counter1 = check(answers, num1);
            int counter2 = check(answers, num2);
            int counter3 = check(answers, num3);

            int max = Math.max(Math.max(counter1, counter2), counter3);

            if (counter1 == max) {
                answer.add(1);
            }

            if (counter2 == max) {
                answer.add(2);
            }

            if (counter3 == max) {
                answer.add(3);
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }

        public int check(int[] answers, int[] values) {
            int counter = 0;
            for (int i = 0; i < answers.length; i++) {
                int index = i % values.length;
                if (answers[i] == values[index]) {
                    counter++;
                }
            }

            return counter;
        }
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
