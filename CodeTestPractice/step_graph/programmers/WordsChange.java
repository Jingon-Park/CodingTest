package step_graph.programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class WordsChange {
    static class Solution {

        Queue<String> queue = new LinkedList<>();
        boolean[] visited;
        public int solution(String begin, String target, String[] words) {
            if (!Arrays.asList(words).contains(target)) {
                return 0;
            }

            int answer = 0;

            visited = new boolean[words.length];
            queue.add(begin);

            while (!queue.isEmpty()) {
                int repeatSize = queue.size();
                for (int i = 0; i < repeatSize; i++) {
                    String currentString = queue.poll();
                    if (currentString.equals(target)) {
                        return answer;
                    }

                    for (int j = 0; j < words.length; j++) {
                        if (checkLinked(currentString, words[j]) && !visited[j]) {
                            visited[j] = true;
                            queue.add(words[j]);
                        }
                    }
                }
                answer++;
            }

            return 0;
        }

        public boolean checkLinked(String first, String second) {
            int diff = 0;//first와  second의 다른 문자 갯수

            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    diff++;
                }

                if (diff > 1) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
        Solution solution = new Solution();

        int result = solution.solution(begin, target, words);
        System.out.println(result);
    }
}
