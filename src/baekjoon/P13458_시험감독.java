package baekjoon;

import java.util.*;
import java.io.*;

public class P13458_시험감독 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.valueOf(st.nextToken()); // 시험장 수
		
		st = new StringTokenizer(br.readLine(), " "); // 각 고사장별 응시자 수
		
		StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
		int B = Integer.valueOf(st2.nextToken()); // 총감독관 감시자 수
		int C = Integer.valueOf(st2.nextToken()); // 부감독관 감시자 수
		
		long cnt = N;
		int cur = 0;
		for(int i = 0; i < N; i++) {
			cur = Integer.valueOf(st.nextToken()) - B;
			
			if(cur>0) {
				cnt += ((cur + C - 1)/C);
			}
		}
		
		System.out.println(cnt);
	}
}