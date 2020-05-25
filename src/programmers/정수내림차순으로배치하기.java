package programmers;

import java.util.*;

public class 정수내림차순으로배치하기 {

	public static void main(String[] args) {
		long n = 118372;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
        long answer = 0;
        
        String[] arr_n = String.valueOf(n).split("");
        Arrays.sort(arr_n, Collections.reverseOrder());
        answer = Long.valueOf(String.join("", arr_n));        
        
        return answer;
    }
}