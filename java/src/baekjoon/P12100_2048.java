package baekjoon;

import java.util.*;
import java.io.*;

public class P12100_2048 {
	public static int res, N;
	public static int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.valueOf(st.nextToken());
		
		int[][] board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) board[i][j] = Integer.valueOf(st.nextToken());
		}
		
		dfs(board, 0);
		
		System.out.println(res);
	}
	
	public static void dfs(int[][] board, int cnt) {
		if(cnt>=5) {
			res = Math.max(res, check_board(board));
			return;
		}
		
		for(int dir = 0; dir < 4; dir++) { // 상하좌우
			dfs(move_numbers(board, dir), cnt+1);
		}
	}
	
	public static int check_board(int[][] board) {
		int max = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) max = Math.max(max, board[i][j]);
		}
		
		return max;
	}
	
	public static int[][] move_numbers(int[][] board, int dir){
		boolean[][] change = new boolean[N][N];
		int[][] tmp = new int[N][N];
		
		int cur = -1;
		for(int i = 0; i < N; i++) {
			int idx = (dir==0 || dir==2) ? 0 : N-1;
			for(int j = 0; j < N; j++) {
				switch(dir){
					case 0:
						cur = board[j][i];
						break;
					case 1:
						cur = board[N-j-1][i];
						break;
					case 2:
						cur = board[i][j];
						break;
					case 3:
						cur = board[i][N-j-1];
						break;
				}
				
				if(cur==0) continue;
				
				switch(dir){
					case 0:
					case 1:
						if(tmp[idx][i]==0) tmp[idx][i] = cur;
						else {
							if(!change[idx][i] && tmp[idx][i]==cur) {
								tmp[idx][i] *= 2;
								change[idx][i] = true;
							}
							else {
								idx = dir==0 ? idx+1 : idx-1;
								tmp[idx][i] = cur;
							}
						}
						break;
					case 2:
					case 3:
						if(tmp[i][idx]==0)tmp[i][idx] = cur;
						else {
							if(!change[i][idx] && tmp[i][idx]==cur) {
								tmp[i][idx] *= 2;
								change[i][idx] = true;
							}
							else {
								idx = dir==2 ? idx+1 : idx-1;
								tmp[i][idx] = cur;
							}
						}
						break;
				}
			}
		}
		
		return tmp;
	}
}