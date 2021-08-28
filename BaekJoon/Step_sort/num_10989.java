import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class num_10989 {
	public static void main(String[] args) throws IOException {
    
		int[] counter = new int[10001];
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        

        int num = Integer.parseInt(bf.readLine());

        for(int i = 0; i < num; i++){
            int position = Integer.parseInt(bf.readLine());
            counter[position] += 1;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 10001; i++){
            int count = counter[i];
            for(int j = 0; j < count; j++){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
	}
}