package CodeUp100;

import java.util.Scanner;

public class num1023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] parse = input.split("\\.");
		
		System.out.println(parse[0]);
		System.out.println(parse[1]);

	}

}
