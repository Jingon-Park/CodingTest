package step_greedy.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * 큰 수 만들기
 */
public class LargeNumber {

    static class Solution {

        public String solution(String number, int k) {
            ArrayList<Integer> numberList = new ArrayList<>();
            int counter = number.length() - k;
            int startIndex = 0;
            int lastIndex = number.length() - counter + 1;
            for (int i = 0; i < number.length(); i++) {
                numberList.add(Character.getNumericValue(number.charAt(i)));
            }

            String result = "";

            while (counter > 0) {
                List<Integer> integers = numberList.subList(startIndex, lastIndex);
                if (integers.size() == counter) {
                    for (Integer integer : integers) {
                        result += integer;
                    }
                    break;

                }
                Integer max = Collections.max(integers);
                startIndex = integers.indexOf(max) + startIndex + 1;
                counter--;
                result += max;
                lastIndex = Math.min((number.length() - counter + 1), number.length());
            }
            return result;
        }
        class SolutionFromAI {

            public String solution(String number, int k) {
                StringBuilder result = new StringBuilder();
                int n = number.length();
                int startIndex = 0;

                /**
                 * 어떻게 k + i 까지의 탐색 범위가 최적의 해를 보장할 수 있는지?
                 * 나는 매번 n - k - i 번의 선택을 해야한다.
                 * 이때 내가 탐색 범위를 X라고 설정했다면 최대 n - X 이후부터 탐색 할때 n - k - i 번의 선택을 할 수 있을
                 * 만틈 숫자가 남아 있어야한다. n - X >= n - k - i 라면 n - X = n - k - i 이므로 X 는 k + 1 이된다.
                 */
                for (int i = 0; i < n - k; i++) {
                    char maxChar = '0';
                    for (int j = startIndex; j <= k + i; j++) {
                        if (number.charAt(j) > maxChar) {
                            maxChar = number.charAt(j);
                            startIndex = j + 1;
                        }
                    }
                    result.append(maxChar);
                }

                return result.toString();
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String result = solution.solution("4177252841", 4);
        System.out.println(result);

        System.out.println("");
        System.out.println("");
        String solution1 = solution.solution("1924", 2);
        System.out.println(solution1);

    }

}
