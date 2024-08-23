package step_greedy.baekjoon;

import static java.util.Arrays.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class num_1931 {

    static Comparator<Room> comparatorForRoomEnd = new Comparator<Room>() {
        @Override
        public int compare(Room room1, Room room2) {
            if (room1.end == room2.end) {
                return room1.start - room2.start;
            }

            return room1.end - room2.end;
        }
    };

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int endTime = 0;
        int result = 0;

        int num = sc.nextInt();

        Room[] rooms = new Room[num];

        for (int i = 0; i < num; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            Room room = new Room(start, end);
            rooms[i] = room;

        }

        sort(rooms, comparatorForRoomEnd);

        for (int i = 0; i < num; i++) {
            Room room = rooms[i];
            if (room.start >= endTime) {
                endTime = room.end;
                result++;
            }
        }
        System.out.println(result);
    }
}
class Room{
    public int start;
    public int end;

    public Room(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
