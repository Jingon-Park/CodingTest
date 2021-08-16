import java.util.*;


public class num_2751 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuffer bf = new StringBuffer();

        int count = sc.nextInt();
        ArrayList<Integer> input = new ArrayList<>();

        for(int i = 0; i < count; i++){
            input.add(sc.nextInt());
        }

        Collections.sort(input);

        for(Integer num : input){
            bf.append(num).append("\n");
        }

        System.out.println(bf);

    }
    
    
}
