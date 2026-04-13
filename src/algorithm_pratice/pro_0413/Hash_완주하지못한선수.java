package algorithm_pratice.pro_0413;
import java.util.HashMap;

public class Hash_완주하지못한선수 {

    public static void main(String[] args) {
        String[][] parti = {
            {"leo", "kiki", "eden"},
            {"marina", "josipa", "nikola", "vinko", "filipa"},
            {"mislav", "stanko", "mislav", "ana"}
        };
        String[][] compli = {
            {"kiki", "eden"},
            {"marina", "josipa", "nikola", "filipa"},
            {"mislav", "stanko", "ana"}
        };
         
        for (int i = 0; i < parti.length; i++) { 
            String answer = solution(parti[i], compli[i]); 
            System.out.println("테스트 케이스 " + (i + 1) + "번 정답: " + answer);
        }
    }
 
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> map = new HashMap<>();
         
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }
         
        for (String c : completion) {
            map.put(c, map.get(c) - 1); 
        }
        
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                answer = key;
                break;  
            }
        }    
        return answer;
    }
}