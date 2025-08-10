package group_study.week_8;

import java.util.HashSet;
import java.util.Set;

public class Num4 {

    static class Solution {

        public int solution(int[] cards) {
            int answer = 0;

            for (int first = 0; first < cards.length; first++) {
                Set<Integer> history = new HashSet<>();
                int firstCounter = openCounter(first, cards, history);
                for (int second = first + 1; second < cards.length; second++) {
                    Set<Integer> backup = new HashSet<>(history);
                    int seconCounter = openCounter(second, cards, backup);
                    answer = Math.max(answer,firstCounter * seconCounter);
                }
            }

            return answer;
        }

        public int openCounter(int startIndex, int[] cards, Set<Integer> history) {
            int index = startIndex;
            int counter = 0;
            while (true) {
                if (history.contains(index)) {
                    return counter;
                }
                history.add(index);
                index = cards[index] - 1;
                counter++;
            }
        }
    }
    public static void main(String[] args) {

        int[] cards = {8, 6, 3, 7, 2, 5, 1, 4};

        Solution solution = new Solution();
        int result = solution.solution(cards);
        System.out.println(result);

    }

}
