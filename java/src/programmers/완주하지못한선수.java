package programmers;

import java.util.*;

public class 완주하지못한선수 {

	public static void main(String[] args) {
		String[] participant = {"leo", "kiki", "eden"};
		String[] completion = {"eden", "kiki"};
		
		System.out.println(solution(participant, completion));
	}
	
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> part = new HashMap<>();
        for(String part_name : participant){
            part.put(part_name, part.getOrDefault(part_name, 0) + 1);
        }
        
        for(String comp_name : completion){
            part.put(comp_name, part.get(comp_name)-1);
        }
        
        for(Map.Entry<String, Integer> entry : part.entrySet()){
            if(entry.getValue()==1){
                answer = entry.getKey();
                break;
            }
        }
        
        return answer;
    }
}