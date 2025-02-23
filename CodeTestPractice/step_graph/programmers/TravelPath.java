package step_graph.programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class TravelPath {
    static class Solution {

        List<String> result = new ArrayList<>();
        boolean[] used;
        public String[] solution(String[][] tickets) {
            used = new boolean[tickets.length];

            dfs(0, "ICN", "ICN", tickets);

            Collections.sort(result);

            return result.get(0).split(" ");
        }

        public void dfs(int depth, String start, String route, String[][] tickets) {
            if (depth == tickets.length) {
                result.add(route);
                return;
            }

            for (int i = 0; i < tickets.length; i++) {
                if (start.equals(tickets[i][0]) && !used[i]) {
                    used[i] = true;
                    String next = tickets[i][1];
                    dfs(depth + 1, next, route + " " + next, tickets);
                    used[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {

        String[][] input = {{"ICN", "ATM"}, {"ICN", "ATL"}, {"ATM", "ATL"}, {"ATL", "ICN"},
            {"ATL", "ATM"}};
        Solution solution = new Solution();
        String[] result = solution.solution(input);
        for (String cur : result) {
            System.out.print(cur + ", ");
        }

    }

}
