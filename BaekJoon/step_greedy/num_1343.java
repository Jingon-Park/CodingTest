package step_greedy;

import java.sql.SQLOutput;
import java.util.Scanner;

public class num_1343 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String POLIONOMY_1 = "AAAA";
        String POLIONOMY_2 = "BB";

        input = input.replaceAll("XXXX", POLIONOMY_1);
        input = input.replaceAll("XX", POLIONOMY_2);

        if (input.indexOf("X") != -1) {
            System.out.println(-1);
        }else{
            System.out.println(input);
        }
    }
}
