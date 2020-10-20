package CodeUp100;

import java.util.Scanner;

public class num1026 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		String[] parse = input.split(":");
		
		int min = Integer.parseInt(parse[1]);
		
		System.out.println(min);
		
	}

}
