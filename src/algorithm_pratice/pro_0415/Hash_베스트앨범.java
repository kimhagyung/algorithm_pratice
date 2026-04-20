package algorithm_pratice.pro_0415;
 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;
public class Hash_베스트앨범 {

	public static void main(String[] args) {
		String[] genres = {"classic", "pop", "classic", "classic", "pop"};
		int[] plays = {500, 600, 150, 800, 2500};
		Solution sol = new Solution();
		int[] result = sol.solution(genres, plays);
		 
		Arrays.stream(result).forEach(r -> System.out.println(r));
		
	} 

}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        
        HashMap<String, Integer> map = new HashMap<>(); // 장르별 플레이수 합  
        HashMap<String, ArrayList<Song>> finalMap = new HashMap<>(); // <장르, {index, plays}> 
        
        for(int i = 0; i < genres.length; i++){
        	//1. 각 장르의 합 
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
            
            //2. 장르와 인덱스 플레이수 저장 
            if(!finalMap.containsKey(genres[i])){
                finalMap.put(genres[i], new ArrayList<>());
            }
            finalMap.get(genres[i]).add(new Song(i, plays[i]));
        }
        
        //3. map에서 장르의 플레이수 합 내림차순 
        ArrayList<String> genreList = new ArrayList<>(map.keySet());
        genreList.sort((g1, g2) -> map.get(g2) - map.get(g1));

        //4. 장르별 플레이수 내림차순 정렬 
        ArrayList<Integer> answerList = new ArrayList<>();
        for(String genre : genreList){
            ArrayList<Song> songs = finalMap.get(genre);

            // Collections은 리스트에서 사용(배열에서는 Arrays.sort())
            // Song 클래스에 compareTo를 정의해 뒀기 때문에 동작 가능 
            Collections.sort(songs); 
            
            // 장르별로 가장 많이 재샌된 노래 최대 두개 까지 모아 베스트 앨범 출시 조건 
            answerList.add(songs.get(0).id);
            if(songs.size() > 1){
                answerList.add(songs.get(1).id);
            }
        }
               
        // 5. 반환 
        int[] answer = new int[answerList.size()];
        for(int i = 0; i < answerList.size(); i++){
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
                    
class Song implements Comparable<Song> {
    int id; 
    int play;
    
    Song(int id, int play) {
        this.id = id;
        this.play = play;
    }
    
    // 비교 함수 재정의  
    @Override
    public int compareTo(Song other){
        if(this.play == other.play){
            return this.id - other.id;
        }
        return other.play - this.play;
    }
}