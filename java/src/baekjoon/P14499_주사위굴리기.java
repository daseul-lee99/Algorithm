package baekjoon;

import java.util.*;
import java.io.*;

public class P14499_주사위굴리기 {
	static public class Dice{
		int top; int bottom;
		int west; int east;
		int south; int north;
		
		Dice(int top, int bottom, int west, int east, int south, int north){
			this.top = top; this.bottom = bottom;
			this.west = west; this.east = east;
			this.south = south; this.north = north;
		}
		
		void setValues(int top, int bottom, int west, int east, int south, int north){
			this.top = top; this.bottom = bottom;
			this.west = west; this.east = east;
			this.south = south; this.north = north;
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		int x = Integer.valueOf(st.nextToken());
		int y = Integer.valueOf(st.nextToken());
		int K = Integer.valueOf(st.nextToken());
		
		int[][] map = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) map[i][j] = Integer.valueOf(st.nextToken());
		}
		
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine());
		
		// 초기: 0-top, 1-bottom, 2-west, 2-east, 4-south, 5-north
		Dice dice = new Dice(0, 0, 0, 0, 0, 0);
		
		int[] dx = {0, 0, -1, 1}, dy = {1, -1, 0, 0}; // 동서북남
		int nx = 0, ny = 0, dir = 0;
		for(int i = 0; i < K; i++) {
			dir = Integer.valueOf(st.nextToken())-1;
			
			nx = x+dx[dir]; ny = y+dy[dir];
			if(0<=nx && nx<N && 0<=ny && ny<M) {
				switch(dir) {
				case 0: // 동
					dice.setValues(dice.west, dice.east, dice.bottom, dice.top, dice.south, dice.north);
					break;
				case 1: // 서
					dice.setValues(dice.east, dice.west, dice.top, dice.bottom, dice.south, dice.north);
					break;
				case 2: // 북
					dice.setValues(dice.south, dice.north, dice.west, dice.east, dice.bottom, dice.top);
					break;
				case 3: // 남
					dice.setValues(dice.north, dice.south, dice.west, dice.east, dice.top, dice.bottom);
					break;
				}
				
				if(map[nx][ny]==0) map[nx][ny] = dice.bottom;
				else {
					dice.bottom = map[nx][ny];
					map[nx][ny] = 0;
				}
				sb.append(dice.top + "\n");
				
				x = nx; y = ny;
			}
		}
		System.out.println(sb.toString());
	}
}