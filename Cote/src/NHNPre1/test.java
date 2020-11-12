package NHNPre1;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(fivo(5));
	}
	static int fivo(int n){
		if(n >= 2) {
			return fivo(n -2) + fivo(n - 1);
		}else
			return n;
		
	}

}
