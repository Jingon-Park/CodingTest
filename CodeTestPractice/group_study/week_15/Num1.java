package group_study.week_15;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Num1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num = Integer.parseInt(br.readLine());

        int[] boxs = new int[num];


        String[] input = br.readLine().split(" ");
        for (int i = 0; i < num; i++) {
            boxs[i] = Integer.parseInt(input[i]);
        }

        Stack<int[]> stack = new Stack<>();

        for (int i = 0; i < boxs.length; i++) {
            int target = boxs[i];

            int largeBox =(int) Arrays.stream(boxs).skip(i).filter(value -> value > target).count();

            if (stack.isEmpty()) {
                stack.add(new int[]{target,largeBox});
                continue;
            }

            while (!stack.isEmpty()) {
                int[] before = stack.peek();

                if (target > before[0]) {
                    stack.add(new int[]{target, largeBox});
                    break;
                }

                if (largeBox < before[1]) {
                    continue;
                }
                stack.pop();
            }
        }

        System.out.println(stack.size());
    }

}
