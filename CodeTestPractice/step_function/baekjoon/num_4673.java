package step_function.baekjoon;

public class num_4673 {

	public static void main(String[] args) {
		boolean[] check = new boolean[10001];
		
		for(int i = 1; i <= 10000; i++) {
			int result = d(i);
			check[result] = true;
		}
		
		for(int j = 1; j <= 10000; j++) {
			if(!check[j]) {
				System.out.println(j);
			}
		}

	}
	public static int d(int num) {
		int anw = num;
		
		
		while(!(num == 0)) {
			anw += num % 10;
			num /= 10;
		}
		if(anw > 10000) {
			return 0;
		}
		return anw;
	}

}
