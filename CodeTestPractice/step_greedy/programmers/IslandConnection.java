package step_greedy.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class IslandConnection {
    static class Solution {
        public static int [] parent; // 유니온 파인드에서 부모 노드를 저장하는 배열

        public int solution(int n, int[][] costs) {
            int answer = 0; // MST(최소 신장 트리)의 총 비용을 저장하는 변수
            int counter = 0; // 선택한 간선 개수 (MST 완성 여부 확인용)
            parent = new int[n]; // 부모 배열 초기화

            // 간선 리스트 정렬 (비용 기준 오름차순)**
            Arrays.sort(costs, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2]; // 간선 비용 기준 정렬 (오름차순)
                }
            });

            // 유니온 파인드 초기화 (각 노드는 자기 자신을 부모로 설정)**
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            // 간선을 하나씩 선택하여 MST를 구성**
            for (int i = 0; i < costs.length; i++) {
                if (counter >= n - 1) { // MST가 완성되었으면 종료 (간선 개수 = 노드 개수 - 1)
                    break;
                }

                int a = costs[i][0]; // 간선의 출발 노드
                int b = costs[i][1]; // 간선의 도착 노드
                int cost = costs[i][2]; // 간선의 비용

                // 유니온 연산을 통해 사이클 확인 후 간선 추가**
                if (union(a, b)) { // 두 노드가 같은 집합이 아니라면 연결
                    answer += cost; // MST 비용 추가
                    counter++; // 선택한 간선 개수 증가
                }
            }

            return answer; // 최소 신장 트리의 총 비용 반환
        }

        //유니온 연산: 두 집합을 병합하는 함수**
        public boolean union(int a, int b) {
            int rootA = find(a); // a의 대표 노드 찾기
            int rootB = find(b); // b의 대표 노드 찾기

            if (rootA == rootB) { // 두 노드가 같은 집합이면 사이클 발생 (연결 불가)
                return false;
            }

            parent[rootA] = rootB; // rootA의 부모를 rootB로 설정하여 병합
            return true;
        }

        // 경로 압축을 적용한 find 연산 (대표 노드 찾기)**
        private int find(int a) {
            if (parent[a] == a) { // 자기 자신이 부모면 대표 노드
                return a;
            }
            return parent[a] = find(parent[a]); // 경로 압축: 탐색한 노드들을 직접 루트에 연결
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 4;
        int[][] costs = {{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        int result = solution.solution(n, costs);
        System.out.println(result);
    }
}
