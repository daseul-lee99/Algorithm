package baekjoon;

import java.util.*;
import java.io.*;

public class P14500_테트로미노 {
	public static int[][][] tetrominos =
		{{{0, 0}, {0, 1}, {0, 2}, {0, 3}}, // 1x4
		 {{0, 0}, {1, 0}, {2, 0}, {3, 0}}, // 4x1
		 {{0, 0}, {0, 1}, {1, 0}, {1, 1}}, // 2x2
		 {{0, 0}, {1, 0}, {2, 0}, {2, 1}}, // L 모양
		 {{0, 0}, {1, 0}, {2, 0}, {2, -1}}, // L 반대(좌우) 모양
		 {{0, 0}, {0, 1}, {1, 1}, {2, 1}}, // 세로로 긴 ㄱ 모양
		 {{0, 1}, {0, 0}, {1, 0}, {2, 0}}, // 세로로 긴 ㄱ 반대(좌우) 모양
		 {{0, 0}, {0, 1}, {0, 2}, {1, 2}}, // 가로로 긴 ㄱ 모양
		 {{0, 2}, {0, 1}, {0, 0}, {1, 0}}, // 가로로 긴 ㄱ 반대(좌우) 모양
		 {{0, 0}, {1, 0}, {1, 1}, {1, 2}}, // 가로로 긴 ㄴ 모양
		 {{0, 2}, {1, 2}, {1, 1}, {1, 0}}, // 가로로 긴 ㄴ 반대(좌우) 모양
		 {{0, 0}, {1, 0}, {1, 1}, {2, 1}}, // 번개 모양
		 {{0, 0}, {1, 0}, {1, -1}, {2, -1}}, // 번개 반대(좌우/상하) 모양
		 {{0, 0}, {0, 1}, {1, 1}, {1, 2}}, // 번개 누운 모양
		 {{0, 0}, {0, 1}, {-1, 1}, {-1, 2}}, // 번개 누운 반대 모양
		 {{0, 0}, {0, 1}, {1, 1}, {0, 2}}, // ㅜ 모양
		 {{0, 0}, {0, 1}, {-1, 1}, {0, 2}}, // ㅗ 모양
		 {{0, 0}, {1, 0}, {1, 1}, {2, 0}}, // ㅏ 모양
		 {{0, 0}, {1, 0}, {1, -1}, {2, 0}}, // ㅓ 모양
		};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.valueOf(st.nextToken());
		int M = Integer.valueOf(st.nextToken());
		
		int[][] paper = new int[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) paper[i][j] = Integer.valueOf(st.nextToken());
		}
		
		int max = 0;
		for(int x = 0; x < N; x++) {
			for(int y = 0; y < M; y++) {
				for(int[][] tetromino : tetrominos) {
					int sum = 0;
					for(int[] pos : tetromino) {
						int nx = x+pos[0], ny = y+pos[1];
						if(0<=nx && nx<N && 0<=ny && ny<M) sum += paper[nx][ny];
						else {
							sum = 0;
							break;
						}
					}
					max = Math.max(max, sum);
				}
			}
		}
		
		System.out.println(max);
	}
}