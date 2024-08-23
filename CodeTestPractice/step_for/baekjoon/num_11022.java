package step_for.baekjoon;

import java.util.Scanner;

public class num_11022 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int time = sc.nextInt();
		
		for(int i = 1; i <= time; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			System.out.println("Case #" + i +": " + num1 + " + " + num2 + " = " + (num1 + num2));
		}
	}

}
