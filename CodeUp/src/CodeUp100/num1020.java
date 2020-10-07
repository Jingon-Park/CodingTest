package CodeUp100;

import java.util.Scanner;

public class num1020 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		String[] parse = input.split("-");
		
		System.out.format("%s%s", parse[0],parse[1]);
		sc.close();
		
	}

}
