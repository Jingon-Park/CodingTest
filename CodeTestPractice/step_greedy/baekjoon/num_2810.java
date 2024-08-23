package step_greedy.baekjoon;

import java.util.Scanner;

public class num_2810 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num = sc.nextInt();

        String seatInfo = sc.next();

        seatInfo = seatInfo.replaceAll("LL", "S");

        int maxNum = seatInfo.length() + 1;

        System.out.println(maxNum > num ? num : maxNum);
    }
}
