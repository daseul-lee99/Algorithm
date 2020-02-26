package baekjoon;

import java.io.*;
import java.util.*;

public class P13460_구슬탈출2 {
	public static int N, M;
	public static int hole_y, hole_x;
	public static int min;
	
	private static char[][] tilting(int dir, int by, int bx, int ry, int rx, char[][] board) {
		char[][] board_cpy = new char[N][M];
		for(int n = 0; n < N; n++) board_cpy[n] = board[n].clone();
		
		// 기울이는 방향 정하기 //
		int dy = 0, dx = 0;
		if		(dir==0) { dx = -1; } // 왼쪽으로
		else if	(dir==1) { dx =  1; } // 오른쪽으로
		else if	(dir==2) { dy = -1; } // 위쪽으로
		else 			 { dy =  1; } // 아래쪽으로
		// END: 기울이는 방향 정하기 //
		
		// 기울이기 //
		boolean b_hole = false, r_hole = false;
		if(dx==-1) { // 왼쪽으로
			boolean move = true;
			while(move) {
				move = false;
				
				if(!r_hole && 0<rx+dx && (board_cpy[ry][rx+dx]=='.' || board_cpy[ry][rx+dx]=='O')) { 
					board_cpy[ry][rx] = '.';
					rx+=dx; move = true;
					if(ry==hole_y && rx==hole_x) r_hole = true;
					else board_cpy[ry][rx] = 'R';
				}
				if(!b_hole && 0<bx+dx && (board_cpy[by][bx+dx]=='.' || board_cpy[by][bx+dx]=='O')) {
					board_cpy[by][bx] = '.';
					bx+=dx; move = true;
					if(by==hole_y && bx==hole_x) b_hole = true;
					else board_cpy[by][bx] = 'B';
				}
			}
		}
		else if(dx==1) { // 오른쪽으로
			boolean move = true;
			while(move) {
				move = false;
				
				if(!r_hole && rx+dx<M-1 && (board_cpy[ry][rx+dx]=='.' || board_cpy[ry][rx+dx]=='O')) {
					board_cpy[ry][rx] = '.';
					rx+=dx; move = true;
					if(ry==hole_y && rx==hole_x) r_hole = true;
					else board_cpy[ry][rx] = 'R';
				}
				if(!b_hole && bx+dx<M-1 && (board_cpy[by][bx+dx]=='.' || board_cpy[by][bx+dx]=='O')) {
					board_cpy[by][bx] = '.';
					bx+=dx; move = true;
					if(by==hole_y && bx==hole_x) b_hole = true;
					else board_cpy[by][bx] = 'B';
				}
			}
		}
		else if(dy==-1) { // 위쪽으로
			boolean move = true;
			while(move && !r_hole && !b_hole) {
				move = false;
				
				if(!r_hole && 0<ry+dy && (board_cpy[ry+dy][rx]=='.' || board_cpy[ry+dy][rx]=='O')) {
					board_cpy[ry][rx] = '.';
					ry+=dy; move = true;
					if(ry==hole_y && rx==hole_x) r_hole = true;
					else board_cpy[ry][rx] = 'R';
				}
				if(!b_hole && 0<by+dy && (board_cpy[by+dy][bx]=='.' || board_cpy[by+dy][bx]=='O')) {
					board_cpy[by][bx] = '.';
					by+=dy; move = true;
					if(by==hole_y && bx==hole_x) b_hole = true;
					else board_cpy[by][bx] = 'B';
				}
			}
		}
		else { // 아래쪽으로
			boolean move = true;
			while(move && !r_hole && !b_hole) {
				move = false;
				
				if(!r_hole && ry+dy<N-1 && (board_cpy[ry+dy][rx]=='.' || board_cpy[ry+dy][rx]=='O')) {
					board_cpy[ry][rx] = '.';
					ry+=dy; move = true;
					if(ry==hole_y && rx==hole_x) r_hole = true;
					else board_cpy[ry][rx] = 'R';
				}
				if(!b_hole && by+dy<N-1 && (board_cpy[by+dy][bx]=='.' || board_cpy[by+dy][bx]=='O')) {
					board_cpy[by][bx] = '.';
					by+=dy; move = true;
					if(by==hole_y && bx==hole_x) b_hole = true;
					else board_cpy[by][bx] = 'B';
				}
			}
		}
		// END: 기울이기 //
		
		// 구슬 이동 후 구슬 위치 확인 //
//		if(r_hole && !b_hole) return true;
//		else return false;
		// END: 구슬 이동 후 구슬 위치 확인 //
		return board_cpy;
	}
	
	private static void run(int n, int i, char[][] board) {
		if(n>10) return;
		
		// 구슬 위치 확인 //
		int by = 0, bx = 0, ry = 0, rx = 0;
		boolean find_b = false, find_r = false;
		for(int y = 0; y < N; y++) {
			for(int x = 0; x < M; x++) {
				if(board[y][x]=='B') { by = y; bx = x; find_b = true; }
				if(board[y][x]=='R') { ry = y; rx = x; find_r = true; }
			}
		}
		//  END: 구슬 위치 확인 //
		
		// 구슬 이동 후 구멍이 들어갔는지 확인 //
		if(!find_b || (!find_b && !find_r)) return;
		else if(!find_r) {
			min = Math.min(min, n);
			return;
		}
		// END: 구슬 이동 후 구멍이 들어갔는지 확인 //
		
		for(int j = 0; j < 4; j++) { // 기울이는 방향 4가지
			char[][] board_cpy = tilting(j, by, bx, ry, rx, board);
			run(n+1, j, board_cpy);
		}
		
	}

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// input data //
		N = Integer.parseInt(st.nextToken()); // 보드의 가로
		M = Integer.parseInt(st.nextToken()); // 보드의 세로
		
		// .: 빈 칸, #: 장애물or벽(공 이동X), O: 구멍의 위치, R: 빨간 구슬 위치, B: 파란 구슬 위치 //
		char[][] board = new char[N][M];
		for(int i = 0; i < N; i++) {
			String s = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if(c=='O') { hole_y = i; hole_x = j; }
				
				board[i][j] = c;
			}
		}
		// END: input data //
		
		min = Integer.MAX_VALUE;
		run(0, 0, board);
		
		if(min==Integer.MAX_VALUE) System.out.println("-1");
		else System.out.println(min);
	}
}