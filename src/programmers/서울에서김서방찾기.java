package programmers;

import java.util.*;

public class 서울에서김서방찾기 {

	public static void main(String[] args) {
		String[] seoul = {"Jane", "Kim"};
		System.out.println(solution(seoul));
	}

	public static String solution(String[] seoul) {
        String answer = "";
        
        int x = Arrays.asList(seoul).indexOf("Kim");
        answer = "김서방은 " + x + "에 있다";

        return answer;
    }
}