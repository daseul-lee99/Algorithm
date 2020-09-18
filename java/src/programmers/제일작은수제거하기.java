package programmers;

import java.util.*;

public class 제일작은수제거하기 {

	public static void main(String[] args) {
		int[] arr = {4,3,2,1};
		
		int[] res = solution(arr);
		System.out.println(Arrays.toString(res));
	}

	public static int[] solution(int[] arr) {
        int[] answer = {};
        
        if(arr.length==1) answer = new int[]{-1};
        else{
            int min = Arrays.stream(arr).min().getAsInt();
            answer = Arrays.stream(arr).filter(i -> i!=min).toArray();
        }
        
        return answer;
    }
}