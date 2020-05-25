package programmers;

import java.util.*;

public class 자연수뒤집어배열로만들기 {

	public static void main(String[] args) {
		long n = 12345;
		
		int[] res = solution(n);
		System.out.println(Arrays.toString(res));
	}

	public static int[] solution(long n) {
        int[] answer = {};
        
        int len = (int) Math.log10(n)+1;
        answer = new int[len];
        for(int i = 0; i < len; i++){
            answer[i] = (int) (n%10);
            n /= 10;
        }
        
        return answer;
    }
}