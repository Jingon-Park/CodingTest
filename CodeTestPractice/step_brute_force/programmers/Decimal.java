package programmers;

import java.util.HashSet;
import java.util.Set;

public class Decimal {

    static class Solution {

        Set<Integer> decimalSet = new HashSet<>();
        public int solution(String numbers) {
            int answer = 0;

            boolean[] visited = new boolean[numbers.length()];
            findPrime(numbers, "", visited);

            answer = decimalSet.size();
            return answer;
        }

        public void findPrime(String input, String current, boolean[] visited) {
            if (!current.isEmpty() && checkPrime(current)) {
                decimalSet.add(Integer.valueOf(current));
            }

            for (int i = 0; i < input.length(); i++) {
                if (visited[i]) {
                    continue;
                }

                visited[i] = true;
                findPrime(input, current + input.charAt(i), visited);
                visited[i] = false;
            }
        }

        public boolean checkPrime(String current) {

            int value = Integer.parseInt(current);
            if (value == 0 || value == 1) {
                return false;
            }

            if (value == 2) {
                return true;
            }

            for (int i = 2; i < value; i++) {
                if (value % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        String input = "011";
        Solution solution = new Solution();

        int result = solution.solution(input);
        System.out.println(result);

    }


}
