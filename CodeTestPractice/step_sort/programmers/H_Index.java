package programmers;

import java.util.Arrays;

public class H_Index {
    static class Solution {
        public int solution(int[] citations) {
            int answer = 0;
            int maxIndex = citations.length;

            Arrays.sort(citations);

            while (maxIndex > 0) {
                int finalMaxIndex = maxIndex;
                long count = Arrays.stream(citations).filter(value -> value >= finalMaxIndex).count();
                if (maxIndex <= count) {
                    return maxIndex;
                }else{
                    maxIndex--;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] input = {3, 0, 6, 1, 5};
        int solution1 = solution.solution(input);

        System.out.println("solution1 = " + solution1);
    }
}
