package programmers;

import java.util.*;

public class 나누어떨어지는숫자배열 {

	public static void main(String[] args) {
		int[] arr = {5, 9, 7, 10};
		int divisor = 5;
		
		int[] res = solution(arr, divisor);
		System.out.println(Arrays.toString(res));
	}

	public static int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        
        List<Integer> vals = new ArrayList<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] % divisor == 0) vals.add(arr[i]);
        }
        
        if(vals.size() == 0) answer = new int[]{-1};
        else{
            Collections.sort(vals);
            
            answer = new int[vals.size()];
            for(int i = 0; i < vals.size(); i++){
                answer[i] = vals.get(i);
            }
        }
        
        return answer;
    }
}