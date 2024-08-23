package step_greedy.baekjoon;

import java.util.Scanner;

public class num_10162 {

    static final int BUTTON_A = 300;
    static final int BUTTON_B = 60;
    static final int BUTTON_C = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String result = "";

        int time = sc.nextInt();

        result += (time / BUTTON_A) + " ";
        time %= BUTTON_A;

        result += (time / BUTTON_B) + " ";
        time %= BUTTON_B;

        result += (time / BUTTON_C);
        time %= BUTTON_C;

        if (time == 0) {
            System.out.println(result);
        }else{
            System.out.println("-1");
        }



    }


}
