package programmers;

import java.util.*;

public class 크레인인형뽑기게임 {

	public static void main(String[] args) {
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};

		System.out.println(solution(board, moves));
	}
	
	public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> basket = new Stack<>();
        for(int i = 0; i < moves.length; i++){
            int pos = moves[i] - 1;
            for(int j = 0; j < board.length; j++){
                if(board[j][pos]==0) continue;
                
                else {
                    if(!basket.isEmpty() && basket.peek().equals(board[j][pos])){
                        basket.pop();
                        answer++;
                    }
                    else basket.push(board[j][pos]);
                    board[j][pos] = 0;
                    
                    break;
                }
            }
        }
        
        return answer*2;
    }

}