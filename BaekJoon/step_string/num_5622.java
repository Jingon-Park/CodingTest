package step_string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class num_5622  {

	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int counter = 0;
		
		for(int i = 0; i < input.length(); i++) {
			char a = input.charAt(i);
			switch (a) {
				case 'A': case 'B': case 'C':
					counter += 3;
					break;
				case 'D': case 'E': case 'F':
					counter +=4;
					break;
				case 'G': case 'H': case 'I':
					counter += 5;
					break;
				case 'J': case 'K': case 'L':
					counter += 6;
					break;
				case 'M': case 'N': case 'O':
					counter += 7;
					break;
				case 'P': case 'Q': case 'R': case 'S':
					counter += 8;
					break;
				case 'T': case 'U': case 'V':
					counter +=9;
					break;
				default :
					counter += 10;
					break;
					
			}
				
		}
		System.out.println(counter);
		
	}

}
