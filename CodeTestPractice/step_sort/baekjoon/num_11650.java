package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

class Positions implements Comparable<Positions>{
    private int x;
    private int y;
    
    public Positions(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Positions p){
        if((p.getX() - getX()) == 0){
            return getY() - p.getY();
        }else{
            return getX() - p.getX();
        }
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}

public class num_11650 {
    public static void main(String[] args) throws Exception{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(bf.readLine());
        ArrayList<Positions> input = new ArrayList<>();

        for(int i = 0; i < count; i++){
            String line = bf.readLine();
            String[] parse = line.split(" ");
            Positions newPositions = new Positions(Integer.parseInt(parse[0]), Integer.parseInt(parse[1]));
            input.add(newPositions);
        }

        Collections.sort(input);

        for(Positions test: input){
            System.out.println(test.getX() + " " + test.getY());
        }

    }
    
}

