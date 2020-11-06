package Step_String;

import java.util.Scanner;

public class num_1152 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		
		input = input.trim();
		String[] split = input.split(" ");
		
		System.out.println(split.length);
	}

}
