package group_study.week_8;

public class Num2 {
    static class Solution {
        public int solution(int n, int[] stations, int w) {

            int answer = 0;
            //가장 처음 기지국에서 최소값과 최대값
            int min = Math.max(stations[0] - w, 1);
            int max = stations[0] + w;
            //처음 기지국의 최소값에서 가장 왼쪽 모두 커버하기 위해 필요한 기지국 갯수
            if (1 < min) {
                answer += getNeedStation(1, min - 1, w);
            }


            //stations 기지국의 크기만큼 반복 (10,000이라 시간 초과X일듯)
            for (int i = 1; i < stations.length; i++) {
                //현재 기지국에서 커버할 수 있는 최소값과 최대값
                int currentMin = stations[i] - w;
                int currentMax = stations[i] + w;
                //이전 기지국에서 커버한 최대값과 현재 기지국에서 커버할 수 있는 최소값 비교
                if (max < currentMin - 1) {//이전과 현재 기지국의 영역에서 겹치지 않는 구간을 확인하기 위해 -1
                    answer += getNeedStation(max + 1, currentMin - 1, w);//max까지는 현재 커버하고 있는 구간이므로 max + 1 ~ 현재 최소값까지 커버하기 위해 필요한 기지국 갯수
                }
                max = currentMax;
                if (currentMax >= n) {
                    break;
                }
            }

            if (max < n) {
                answer += getNeedStation(max + 1, n, w);
            }
            return answer;
        }

        public int getNeedStation(int start, int end, int w) {
            int distance = end - start + 1;
            int coverage = w * 2 + 1;
            return distance % coverage == 0 ? distance / coverage : distance / coverage + 1;
        }
    }
    public static void main(String[] args) {

//        int n = 11;
//        int[] stations = {4, 11};
//        int w = 1;
        int n = 16;
        int[] stations = {9};
        int w = 2;
        Solution solution = new Solution();

        int result = solution.solution(n, stations, w);
        System.out.println(result);


    }

}
