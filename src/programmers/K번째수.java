package programmers;

import java.util.*;

public class K번째수 {
	public static void main(String[] args) {
		int[] array = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		int[] res = solution(array, commands);
		for(int i = 0; i < res.length; i++) {
			System.out.print(res[i] + " ");
		}
		
	}

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
        
        for(int i = 0; i < commands.length; i++){
            int[] tmp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);

            Arrays.sort(tmp);
            answer[i] = tmp[commands[i][2]-1];
        }
        
        return answer;
    }
}