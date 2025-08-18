package group_study.week_10;

import java.util.*;
public class Num1 {

    static class Solution {
        public String[] solution(String[] s) {
            String[] answer = new String[s.length];

            for(int x = 0; x < s.length; x++) {
                String str = s[x];
                int patterCounter = 0;
                Stack<Character> stack = new Stack<>();
                int oneCounter = 0;

                for(int i = 0; i < str.length(); i++) {
                    char target = str.charAt(i);
                    if (target == '1') {
                        oneCounter++;
                    }

                    if (target == '0' && oneCounter >= 2) {
                        patterCounter++;
                        stack.pop();
                        stack.pop();
                        oneCounter -= 2;
                        continue;
                    }

                    if (target == '0') {
                        oneCounter = 0;
                    }
                    stack.push(target);
                }

                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }

                sb.reverse();

                int index = sb.lastIndexOf("0");
                StringBuilder result = new StringBuilder();

                if (index == -1) {

                    for(int i = 0; i < patterCounter; i++){
                        result.append("110");
                    }
                    answer[x] = result.append(sb).toString();
                } else {
                    result.append(sb.substring(0, index + 1));
                    for(int i = 0; i < patterCounter; i++){
                        result.append("110");
                    }
                    result.append(sb.substring(index + 1));
                    answer[x] = result.toString();
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {

    }

}
