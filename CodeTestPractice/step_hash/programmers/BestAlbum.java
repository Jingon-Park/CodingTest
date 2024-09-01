package step_hash.programmers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import step_hash.programmers.Clothes.Solution;

public class BestAlbum {

    static class Solution {
        public static int[] solution(String[] genres, int[] plays) {
            List<Integer> answer = new ArrayList<>();

            Map<String, Integer> genreMap = new HashMap<>();
            Map<String, Map<Integer, Integer>> genreIndexMap = new HashMap<>();

            for (int i = 0; i < genres.length; i++) {
                String genre = genres[i];
                int playCount = plays[i];

                Integer sumPlay = genreMap.getOrDefault(genre, 0);
                sumPlay += playCount;
                genreMap.put(genre, sumPlay);
                Map<Integer, Integer> indexMap = genreIndexMap.getOrDefault(genre,
                    new HashMap<>());
                indexMap.put(i, playCount);
                genreIndexMap.put(genre, indexMap);
            }

            LinkedList<Entry<String, Integer>> genreMapEntry = new LinkedList<>(genreMap.entrySet());
            genreMapEntry.sort(((o1, o2) -> o2.getValue() - o1.getValue()));

            for (Entry<String, Integer> entry : genreMapEntry) {
                String genre = entry.getKey();
                Map<Integer, Integer> indexMap = genreIndexMap.get(genre);

                LinkedList<Entry<Integer, Integer>> genreIndexEntry = new LinkedList<>(
                    indexMap.entrySet());

                genreIndexEntry.sort((o1, o2) -> o2.getValue() - o1.getValue());

                if (genreIndexEntry.size() >= 2) {
                    answer.add(genreIndexEntry.get(0).getKey());
                    answer.add(genreIndexEntry.get(1).getKey());
                }else {
                    answer.add(genreIndexEntry.get(0).getKey());
                }
            }

            return answer.stream().mapToInt(Integer::intValue).toArray();
        }
    }


    public static void main(String[] args) {
        int[] solution = Solution.solution(
            new String[]{"classic", "pop", "classic", "classic", "pop"},
            new int[]{500, 600, 150, 800, 2500});

        for (int i : solution) {
            System.out.println(i);
        }
    }
}
