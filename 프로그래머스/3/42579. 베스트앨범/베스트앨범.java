import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        // 1. 장르별 총 재생 횟수와 노래 리스트를 저장
        Map<String, Integer> genrePlayCount = new HashMap<>();
        Map<String, List<int[]>> genreSongs = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int playCount = plays[i];

            // 장르별 총 재생 횟수 저장
            genrePlayCount.put(genre, genrePlayCount.getOrDefault(genre, 0) + playCount);

            // 장르별 노래 리스트 저장
            genreSongs.putIfAbsent(genre, new ArrayList<>());
            genreSongs.get(genre).add(new int[]{i, playCount}); // [노래 고유 번호, 재생 횟수]
        }

        // 2. 장르를 총 재생 횟수에 따라 내림차순으로 정렬
        List<String> sortedGenres = new ArrayList<>(genrePlayCount.keySet());
        sortedGenres.sort((g1, g2) -> genrePlayCount.get(g2) - genrePlayCount.get(g1));

        // 3. 결과 리스트 작성
        List<Integer> result = new ArrayList<>();
        for (String genre : sortedGenres) {
            // 해당 장르의 노래를 재생 횟수 -> 고유 번호 순으로 정렬
            List<int[]> songs = genreSongs.get(genre);
            songs.sort((s1, s2) -> s2[1] == s1[1] ? s1[0] - s2[0] : s2[1] - s1[1]);

            // 최대 2곡까지 추가
            for (int i = 0; i < Math.min(songs.size(), 2); i++) {
                result.add(songs.get(i)[0]);
            }
        }

        // 결과 반환
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
