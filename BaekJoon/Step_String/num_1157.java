package Step_String;

import java.util.Scanner;

public class num_1157 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next().toUpperCase();
		int[] counter = new int[26];
		int max = 0;
		char anw = ' ';
		
		for(int i = 0; i < input.length(); i++) {
			char text = input.charAt(i);
			counter[(int)text - 65]++;
		}
		
		for(int i = 0; i < 26; i++) {
			if(counter[i] > max) {
				anw = (char)(i + 65);
				max = counter[i];
			}
			else if(counter[i] == max) {
				anw = '?';
			}
				
		}
		System.out.println(anw);
	}

}
