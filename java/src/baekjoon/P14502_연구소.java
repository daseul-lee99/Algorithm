package baekjoon;

import java.util.*;
import java.io.*;

public class P14502_연구소 {
	public static int N, M, safe_area, max_safe_area;
	public static int[] di = {-1, 1, 0, 0}, dj = {0, 0, -1, 1}; // 상하좌우
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		safe_area = 0;
		
		int[][] lab = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				int type = Integer.valueOf(st.nextToken());;
				lab[i][j] = type;
				
				if(type==0) safe_area++;
			}
		}
		
		max_safe_area = 0;
		build_wall(lab, 0);
		System.out.println(max_safe_area);
	}
	
	public static void build_wall(int[][] lab, int n_wall) {
		if(n_wall==3) {
			max_safe_area = Math.max(max_safe_area, spread_virus(lab));
			return;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(lab[i][j]==0) {
					lab[i][j] = 1;
					build_wall(lab, n_wall+1);
					lab[i][j] = 0;
				}
			}
		}
	}
	
	public static int spread_virus(int[][] lab) {
		int[][] tmp_lab = new int[N][M];
		for(int i = 0; i < N; i++) tmp_lab[i] = lab[i].clone();
		
		Queue<int[]> virus = new LinkedList<>();
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(tmp_lab[i][j]==2) virus.offer(new int[] {i, j});
			}
		}
		
		int tmp_safe_area = safe_area-3;
		
		while(!virus.isEmpty()) {
			int[] cur = virus.poll();
			
			for(int d = 0; d < 4; d++) {
				int ni = cur[0]+di[d], nj = cur[1]+dj[d];
				if(0<=ni && ni<N && 0<=nj && nj<M && tmp_lab[ni][nj]==0) {
					tmp_lab[ni][nj] = 2;
					virus.offer(new int[] {ni, nj});
					tmp_safe_area--;
				}
			}
		}
		
		return tmp_safe_area;
	}
}