package baekjoon;

import java.util.*;
import java.io.*;

public class P3190_뱀 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int K = Integer.valueOf(st.nextToken());
		
		// 사과 정보 저장
		boolean[][] board = new boolean[N][N];
		for(int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.valueOf(st.nextToken())-1;
			int x = Integer.valueOf(st.nextToken())-1;
			
			board[y][x] = true;
		}
		
		// 방향 전환 정보 저장
		st = new StringTokenizer(br.readLine());
		int L = Integer.valueOf(st.nextToken());
		Queue<int[]> info = new LinkedList<>();
		for(int i = 0; i < L; i++) {
			st = new StringTokenizer(br.readLine());
			int sec = Integer.valueOf(st.nextToken());
			int dir = st.nextToken().charAt(0)=='L' ? 0:1;
			
			info.add(new int[] {sec, dir});
		}
		int[] cur_info = info.poll();
		int sec = cur_info[0], turn = cur_info[1]; 
				
		int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
		int[][] nxt_dir = {{2, 3}, {3, 2}, {1, 0}, {0, 1}}; // 다음 방향(L, D)
		
		Queue<int[]> snake = new LinkedList<>(); // 뱀 담을 queue
		int y = 0, x = 0, dir = 3; // 뱀 시작 위치, 방향
		snake.add(new int[] {y, x});
		
		int total_sec = 0;
		loop: while(true) {
			total_sec++;
			
			int ny = y+dy[dir], nx = x+dx[dir]; // 머리 한 칸 이동
			if(0>ny || ny>=N || 0>nx || nx>=N) break; // 머리가 벽에 부딪히면 종료
			
			// 머리가 몸통에 부딪히면 종료
			int iter = snake.size();
			for(int i = 0; i < iter; i++) {
				int[] body = snake.poll();
				if(body[0]==ny && body[1]==nx) break loop;
				snake.add(body);
			}
			
			snake.add(new int[] {ny, nx}); // 몸통 늘어남
			if(board[ny][nx]==true) board[ny][nx] = false; // 이동한 칸에 사과가 있으면 사과 먹고
			else { // 이동한 칸에 사과가 없으면 꼬리 이동
				if(!snake.isEmpty()) snake.poll();
			}
			y = ny; x = nx;
			
			if(sec==total_sec) { // 방향 전환
				dir = nxt_dir[dir][turn];
				
				if(!info.isEmpty()){
					cur_info = info.poll();
					sec = cur_info[0]; turn = cur_info[1]; 
				}
			}
		}
		
		System.out.println(total_sec);
	}
}