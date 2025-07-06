package group_study.week_4;

/**
 * 연속된 부분 수열의 합
 */
public class Num2 {
    static class Solution {
        public int[] solution(int[] sequence, int k) {

            int[] answer = {0, Integer.MAX_VALUE};
            int start = 0;//부분 수열의 시작
            int end = start; //부분 수열의 마지막
            int sum = 0; //부분 수열의 합
            while (end < sequence.length) {
                sum += sequence[end]; // start ~ end 까지 부분 수열의 합
                if (sum == k) { //부분 수열의 합이 k와 같을 때
                    if (end - start < answer[1] - answer[0]) {//수열의 길이가 짧은 경우, 같다면 start를 0부터 시작했으므로, 업데이트 X
                        answer[0] = start;
                        answer[1] = end;
                    }
                }

                if (sum > k) {//부분 수열의 합이 k보다 크므로 부분 수열의 크기를 줄여야하는 경우
                    sum -= sequence[start]; //start를 이동해야하므로 지금까지 구한 부분 수열의 합에서 start index의 값만 감소
                    start++; //start index 이동
                    sum -= sequence[end]; //반복문 수행 시 end index의 값만큼 부분 수열의 합을 구하는데, 조건문의 경우는 end index는 업데이트 되지 않았으므로 부분 수열의 합에서 중복 덧샘을 회피하기 위해 감소
                    continue;
                }
                end++;
            }
            return answer;
        }
    }
    public static void main(String[] args) {

        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;

        Solution solution = new Solution();
        int[] result = solution.solution(sequence, k);
        System.out.println(result);

    }

}
