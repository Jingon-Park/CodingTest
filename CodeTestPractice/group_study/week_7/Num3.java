package group_study.week_7;

public class Num3 {


    static class Solution {
        public int[] solution(long[] numbers) {
            int[] answer = new int[numbers.length];

            String[] binaryStringArray = new String[numbers.length];

            for (int i = 0; i < numbers.length; i++) {
                binaryStringArray[i] = getBinary(numbers[i]);
            }

            for (int i = 0; i < binaryStringArray.length; i++) {
                String binary = binaryStringArray[i];
                binary = completeFullBinaryTree(binary);

                boolean b = checkBinary(binary);
                answer[i] = b ? 1 : 0;
            }

            return answer;
        }

        private static String completeFullBinaryTree(String binary) {
            int h = 0; //2진 트리 높이
            while ((Math.pow(2, h)) - 1 < binary.length()) {
                h++;
            }
            // 2진트리 노드 수와 2진수의 길이만큼 앞에 0을 추가
            binary = "0".repeat((int) ((Math.pow(2, h) - 1) - binary.length())) + binary;
            return binary;
        }

        public boolean checkBinary(String binary) {
            if (binary.length() == 1) {
                return true;
            }
            
            int rootIndex = binary.length() / 2;
            char root = binary.charAt(rootIndex);

            String leftTree = binary.substring(0, rootIndex);
            String rightTree = binary.substring(rootIndex + 1);

            if (root == '0') {
                if (leftTree.contains("1") || rightTree.contains("1")) {
                    return false;
                }
            }

            return checkBinary(leftTree) && checkBinary(rightTree);
        }

        public String getBinary(long num) {
            StringBuilder sb = new StringBuilder();

            while (num > 0) {
                long remain = num % 2;
                sb.append(remain);
                num /= 2;
            }

            return sb.reverse().toString();
        }
    }
    public static void main(String[] args) {
        long[] numbers = {7, 42, 5, 58, 95};
        Solution solution = new Solution();

        int[] result = solution.solution(numbers);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
