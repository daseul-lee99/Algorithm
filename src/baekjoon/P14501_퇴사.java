package baekjoon;

import java.util.*;
import java.io.*;

public class P14501_퇴사 {
	public static int N, res;
	public static int[][] consult;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());

		consult = new int[N][2];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			consult[i][0] = Integer.valueOf(st.nextToken());
			consult[i][1] = Integer.valueOf(st.nextToken());
		}
		
		res = 0;
		for(int i = 0; i < N; i++) dfs(i, 0);
		
		System.out.println(res);
	}
	
	public static void dfs(int day, int pay) {
		int nxt_day = day+consult[day][0];
		if(nxt_day<=N) pay += consult[day][1];
		
		if(nxt_day>=N) {
			res = Math.max(res, pay);
			return;
		}

		for(int i = day; i < N; i++) {
			if(i>=nxt_day) dfs(i, pay);
		}
	}
}