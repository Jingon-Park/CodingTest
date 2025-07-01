package group_study.week_3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 충돌위험 찾기 문제
 */
public class Num3 {
    static class Solution {

        // 각 좌표(x, y)에서 특정 시간에 해당 좌표를 지나간 객체 ID를 기록
        Map<Integer, Set<Integer>>[][] timePositionMap = new HashMap[101][101];

        public int solution(int[][] points, int[][] routes) {

            // 좌표마다 시간별 객체 ID를 저장할 맵 초기화
            for (int x = 0; x <= 100; x++) {
                for (int y = 0; y <= 100; y++) {
                    timePositionMap[x][y] = new HashMap<>();
                }
            }

            // 각 객체(route)별로 이동 경로 시뮬레이션
            for (int routeId = 0; routeId < routes.length; routeId++) {
                int currentTime = 0;

                for (int j = 0; j < routes[routeId].length - 1; j++) {
                    int departureIdx = routes[routeId][j] - 1;
                    int arrivalIdx = routes[routeId][j + 1] - 1;

                    int currentX = points[departureIdx][0];
                    int currentY = points[departureIdx][1];
                    int targetX = points[arrivalIdx][0];
                    int targetY = points[arrivalIdx][1];

                    // 출발 좌표에 먼저 경로 기록
                    addRouteAtTime(currentX, currentY, currentTime, routeId);

                    // 한 칸씩 이동하며 경로를 좌표+시간에 기록
                    while (currentX != targetX || currentY != targetY) {
                        if (targetX > currentX) {
                            currentX++;
                        } else if (targetX < currentX) {
                            currentX--;
                        } else if (targetY > currentY) {
                            currentY++;
                        } else if (targetY < currentY) {
                            currentY--;
                        }

                        currentTime++;
                        addRouteAtTime(currentX, currentY, currentTime, routeId);
                    }
                }
            }

            // 충돌 지점 수 세기: 같은 좌표+시간에  2이상 지나간 경우
            int collisionCount = 0;
            for (int x = 1; x <= 100; x++) {
                for (int y = 1; y <= 100; y++) {
                    Map<Integer, Set<Integer>> times = timePositionMap[x][y];
                    for (Set<Integer> routeSet : times.values()) {
                        if (routeSet.size() > 1) {
                            collisionCount++;
                        }
                    }
                }
            }

            return collisionCount;
        }

        private void addRouteAtTime(int x, int y, int time, int routeId) {
            Map<Integer, Set<Integer>> timeMap = timePositionMap[x][y];
            Set<Integer> routesAtTime = timeMap.getOrDefault(time, new HashSet<>());
            routesAtTime.add(routeId);
            timeMap.put(time, routesAtTime);
        }
    }
    public static void main(String[] args) {
        int[][] points = {{3, 2}, {6, 4}, {4, 7}, {1, 4}};
        int[][] routes = {{4, 2}, {1, 3}, {2, 4}};

        Solution solution = new Solution();

        int result = solution.solution(points, routes);
        System.out.println(result);
    }

}
