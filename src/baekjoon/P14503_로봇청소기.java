package baekjoon;

import java.util.*;
import java.io.*;

public class P14503_로봇청소기 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int r = Integer.valueOf(st.nextToken());
		int c = Integer.valueOf(st.nextToken());
		int d = Integer.valueOf(st.nextToken()); // 0:북, 1:동, 2:남, 3:서
		
		int[][] area = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) area[i][j] = Integer.valueOf(st.nextToken());
		}
		
		int[][][] drdc = { // 왼쪽, 후진
				{{0, -1}, {1, 0}},	// 북
				{{-1, 0}, {0, -1}},	// 동
				{{0, 1}, {-1, 0}},	// 남
				{{1, 0}, {0, 1}} 	// 서
		};
		int[] left_dir = {3, 0, 1, 2};
		int[] nxt_rc = {};
		
		int res = 1, cnt = 0;
		area[r][c] = -1;
		int nr = 0, nc = 0;
		while(true) {
			cnt = 0;
			while(cnt<4) {
				nxt_rc = drdc[d][0];
				nr = r+nxt_rc[0]; nc = c+nxt_rc[1];
				
				if(area[nr][nc]==0) {
					cnt = 0;
					r = nr; c = nc; res++;
					d = left_dir[d];
					area[r][c] = -1;
				}
				else {
					d = left_dir[d];
					cnt++;
				}
			}
			nxt_rc = drdc[d][1];
			r += nxt_rc[0]; c += nxt_rc[1];
			
			if(area[r][c]==1) break;
		}
		System.out.println(res);
	}
}