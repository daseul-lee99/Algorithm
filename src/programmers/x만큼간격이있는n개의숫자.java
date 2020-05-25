package programmers;

import java.util.*;

public class x만큼간격이있는n개의숫자 {

	public static void main(String[] args) {
		int x = 2, n = 5;
		
		long[] res = solution(2, 5);
		System.out.println(Arrays.toString(res));
	}

	public static long[] solution(int x, int n) {
        long[] answer = new long[n];
        
        for(int i = 1; i <= n; i++) answer[i-1] = x*(long)i;
        
        return answer;
    }
}