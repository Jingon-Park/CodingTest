package step_graph.programmers;

import java.util.LinkedList;
import java.util.Queue;

public class WordsChange {
    static class Solution {

        Queue<String> queue = new LinkedList<>();
        boolean[] visited;
        public int solution(String begin, String target, String[] words) {
            int answer = 0;

            visited = new boolean[words.length];

            for (int i = 0; i < words.length; i++) {
                if (checkLinked(begin, words[i])) {
                    queue.add(words[i]);
                    visited[i] = true;
                }
            }

            while (!queue.isEmpty()) {
                answer++;
                int repeatCounter = queue.size();

                for (int i = 0; i < repeatCounter; i++) {
                    String compareString = queue.poll();
                    if (compareString.equals(target)) {
                        return answer;
                    }

                    for (int j = 0; j < words.length; j++) {
                        if (checkLinked(compareString, words[j]) && !visited[j]) {
                            queue.add(words[j]);
                            visited[j] = true;
                        }
                    }
                }
            }

            return 0;
        }

        public boolean checkLinked(String first, String second) {
            int counter = 0;

            for (int i = 0; i < first.length(); i++) {
                char target = first.charAt(i);
                char compare = second.charAt(i);
                if (target != compare) {
                    counter++;
                }
                if (counter > 1) {
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
