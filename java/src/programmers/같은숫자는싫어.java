package programmers;

import java.util.*;

public class 같은숫자는싫어 {

	public static void main(String[] args) {
		int[] arr = {1,1,3,3,0,1,1};
		
		int[] res = solution(arr);
		System.out.println(Arrays.toString(res));
	}

	public static int[] solution(int []arr) {
        int[] answer = {};
        
        int pre = arr[0];
        Queue<Integer> que = new LinkedList<>();
        que.offer(pre);
        
        for(int i = 1; i < arr.length; i++){
            if(pre==arr[i]) continue;
            
            pre = arr[i];
            que.offer(pre);
        }
        
        answer = new int[que.size()];
        int i = 0;
        while(!que.isEmpty()) answer[i++] = que.poll();

        return answer;
    }
}