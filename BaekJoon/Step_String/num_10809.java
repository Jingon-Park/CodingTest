package Step_String;

import java.util.Scanner;

public class num_10809 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		for(char i = 'a'; i <= 'z'; i++) {
			System.out.print(input.indexOf(i) + " ");

		}
	}

}
