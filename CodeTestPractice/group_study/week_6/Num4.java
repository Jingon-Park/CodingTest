package group_study.week_6;

import java.util.*;
import java.util.stream.Collectors;

public class Num4 {

    static class Solution {
        public int[] solution(String[] genres, int[] plays) {
            int[] answer = {};

            Map<String, Integer> genresPlayCounter = new HashMap<>();
            Map<String, List<int[]>> playCounterPart = new HashMap<>();
            List<Integer> answerList = new ArrayList<>();


            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int play = plays[i];
                int sumPlay = genresPlayCounter.getOrDefault(genre, 0) + play;
                List<int[]> genrePlayList = playCounterPart.getOrDefault(genre, new ArrayList<>());
                genrePlayList.add(new int[]{i, play});

                genresPlayCounter.put(genre, sumPlay);
                playCounterPart.put(genre, genrePlayList);
            }


            List<String> genresPlayOrder = genresPlayCounter.keySet().stream().sorted(
                new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return genresPlayCounter.get(o2) - genresPlayCounter.get(o1);
                    }
                }).collect(Collectors.toList());

            for (String genre : genresPlayOrder) {
                List<int[]> playCounter = playCounterPart.get(genre);
                Collections.sort(playCounter, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        if (o1[1] == o2[1]){
                            return o1[0] - o2[1];
                        }
                        return o2[1] - o1[1];
                    }
                });
                if (playCounter.size() == 1) {
                    answerList.add(playCounter.get(0)[0]);
                }else {
                    answerList.add(playCounter.get(0)[0]);
                    answerList.add(playCounter.get(1)[0]);
                }
            }
            System.out.println(answerList);
            return answerList.stream().mapToInt(i -> i).toArray();
        }
    }

    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        Solution solution = new Solution();
        int[] solution1 = solution.solution(genres, plays);

        System.out.println(solution1);


    }

}
