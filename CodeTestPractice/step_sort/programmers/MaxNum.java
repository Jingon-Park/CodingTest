package programmers;

import java.util.Arrays;
public class MaxNum {
    static class Solution {
        public String solution(int[] numbers) {
            String answer = "";

            String[] inputToString = new String[numbers.length];

            for (int i = 0; i < inputToString.length; i++) {
                inputToString[i] = String.valueOf(numbers[i]);
            }

            Arrays.sort(inputToString, (o1, o2) -> {
                return (o2 + o1).compareTo(o1 + o2);
            });

            if (inputToString[0].equals("0")) {
                return "0";
            }
            for (String s : inputToString) {
                answer += s;
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        int[] input = {3, 30, 34, 5, 9};

        Solution solution = new Solution();
        System.out.println(solution.solution(input));


    }
}
