package CodeUp100;

import java.util.Scanner;

public class num1025 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		int num = 10000;
		
		for(int i = 0; i < 5; i++) {
			System.out.format("[%d]\n", (input / num) * num);
			input = input % num;
			num = num / 10;
		}
		sc.close();
		
	}

}
