package baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class num_1427 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int input = sc.nextInt();
        ArrayList<Integer> parse = new ArrayList<>();

        while(input / 10 > 0){
            parse.add(input % 10);
            input /= 10;
        }
        parse.add(input);
        Collections.sort(parse, Comparator.reverseOrder());

        for(int number : parse){
            System.out.print(number);
        }
        sc.close();

    }
}
