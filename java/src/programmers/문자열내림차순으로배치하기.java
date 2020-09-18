package programmers;

import java.util.*;

public class 문자열내림차순으로배치하기 {

	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
        String answer = "";
        
        String[] arr_s = s.split("");
        Arrays.sort(arr_s, Collections.reverseOrder());
        answer = String.join("", arr_s);
        
        return answer;
    }
}