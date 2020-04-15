package baekjoon;

import java.util.*;
import java.io.*;

public class P13460_구슬탈출2_bfs {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		// [0],[1]: R 위치, [2],[3]: B 위치, [4]: 순서
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[4], o2[4]);
			}
		});
		
		int[] pos = new int[5];
		char[][] board = new char[N][M];
		String s = "";
		for(int i = 0; i < N; i++) {
			s = br.readLine();
			for(int j = 0; j < M; j++) {
				char c = s.charAt(j);
				if(c=='R') {
					pos[0] = i; pos[1] = j;
				}
				else if(c=='B') {
					pos[2] = i; pos[3] = j;
				}
				else board[i][j] = c;
			}
		}
		pq.add(pos);
		
		int[][][][] v = new int[N][M][N][M];
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				for(int n = 0; n < N; n++) Arrays.fill(v[i][j][n], Integer.MAX_VALUE);
			}
		}
		
		int[] dy = {-1, 1, 0, 0}, dx = {0, 0, -1, 1};
		int res = -1;
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			v[cur[0]][cur[1]][cur[2]][cur[3]] = cur[4];
			
			// 빨간공이 구멍에 들어갔을 때
			if(board[cur[0]][cur[1]]=='O') {
				res = cur[4]++; break;
			}
			
			if(cur[4]>=10) continue;
			
			// 4방향 기울이기(상하좌우)
			for(int d = 0; d < 4; d++) {
				// R
				int ny_r = cur[0], nx_r = cur[1];
				while(true) {
					ny_r+=dy[d]; nx_r+=dx[d];
					if(board[ny_r][nx_r]=='#') {
						ny_r-=dy[d]; nx_r-=dx[d]; break;
					}
					else if(board[ny_r][nx_r]=='O') break;
				}
				
				
				// B
				int ny_b = cur[2], nx_b = cur[3];
				while(true) {
					ny_b+=dy[d]; nx_b+=dx[d];
					if(board[ny_b][nx_b]=='#') {
						ny_b-=dy[d]; nx_b-=dx[d]; break;
					}
					else if(board[ny_b][nx_b]=='O') break;
				}
				
				if(board[ny_b][nx_b]=='O') continue;
				
				if(ny_r==ny_b && nx_r==nx_b) { // 두 공이 같은 위치
					switch(d) {
					case 0:
						if(cur[0]<cur[2]) ny_b++;
						else ny_r++;
						break;
					case 1:
						if(cur[0]<cur[2]) ny_r--;
						else ny_b--;
						break;
					case 2:
						if(cur[1]<cur[3]) nx_b++;
						else nx_r++;
						break;
					case 3:
						if(cur[1]<cur[3]) nx_r--;
						else nx_b--;
						break;
					}
				}
				
				if(v[ny_r][nx_r][ny_b][nx_b]>cur[4]+1) {
					v[ny_r][nx_r][ny_b][nx_b] = cur[4]+1;
					pq.add(new int[] {ny_r, nx_r, ny_b, nx_b, cur[4]+1});
				}
			}
		}
		System.out.println(res);
	}
}