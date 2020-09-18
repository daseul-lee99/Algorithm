package programmers;

import java.util.*;

public class 행렬의덧셈 {

	public static void main(String[] args) {
		int[][] arr1 = {{1, 2}, {2, 3}};
		int[][] arr2 = {{3, 4}, {5, 6}};
		
		int[][] res = solution(arr1, arr2);
		for(int[] r : res) {
			System.out.println(Arrays.toString(r));
		}
	}

	public static int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = {};
        
        answer = new int[arr1.length][arr1[0].length];
        for(int i = 0; i < arr1.length; i++){
            for(int j = 0; j < arr1[0].length; j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        
        return answer;
    }
}