import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class num_11651 {
    public static void main(String[] args) throws Exception{

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int counter = Integer.parseInt(bf.readLine());

        ArrayList<Positions> input = new ArrayList<>();

        for(int i = 0; i < counter; i++){
            String line = bf.readLine();
            String[] parse = line.split(" ");
            input.add(new Positions(Integer.parseInt(parse[0]), Integer.parseInt(parse[1])));
        }

        Collections.sort(input);

        for(Positions data : input){
            System.out.println(data.getX() + " " + data.getY());
        }

        
    }
}

class Position implements Comparable<Positions>{
    private int x;
    private int y;

    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Positions p){
        if(getY() - p.getY() == 0){
            return getX() - p.getX();
        }else{
            return getY() - p.getY();
        }
    }

    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
