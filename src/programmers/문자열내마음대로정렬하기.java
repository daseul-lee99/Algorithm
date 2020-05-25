package programmers;

import java.util.*;

public class 문자열내마음대로정렬하기 {

	public static void main(String[] args) {
		String[] strings = {"sun", "bed", "car"};
		int n = 1;
		
		String[] res = solution(strings, n);
		System.out.println(Arrays.toString(res));
	}

	public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        
        Arrays.sort(strings, new Comparator<String>(){
            public int compare(String s1, String s2){
                char c1 = s1.charAt(n), c2 = s2.charAt(n);
                if(c1 == c2) return s1.compareTo(s2);
                return c1 - c2;
            } 
        });
        
        answer = strings;
        
        return answer;
    }
}