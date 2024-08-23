package step_greedy.baekjoon;

import java.util.*;

public class num_11000 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Lecture> lectureList = new ArrayList<>();

        int endTime = 0;
        int needRoomNum = 0;


        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();

            Lecture lecture = new Lecture(start, end);
            lectureList.add(lecture);
        }

        lectureList.sort(new Comparator<Lecture>() {
            @Override
            public int compare(Lecture o1, Lecture o2) {
                if (o1.start == o2.start) {
                    return o1.end - o1.end;
                }
                return o1.start - o2.start;
            }
        });


        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        priorityQueue.offer(lectureList.get(0).end);

        for (int i = 1; i < lectureList.size(); i++) {
            if (priorityQueue.peek() <= lectureList.get(i).start) {
                priorityQueue.poll();
            }

            priorityQueue.offer(lectureList.get(i).end);
        }

        System.out.println(priorityQueue.size());
    }
}

class Lecture {
    public int start;
    public int end;

    public Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}