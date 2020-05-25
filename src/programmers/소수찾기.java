package programmers;

public class 소수찾기 {

	public static void main(String[] args) {
		int n = 10;
		System.out.println(solution(n));
	}

	public static int solution(int n) {
        int answer = 0;
        
        boolean[] check = new boolean[n+1];
        for(int i = 2; i <= n; i++){
            for(int j = 2; j <= n/i; j++){
                if(!check[i*j]) check[i*j] = true;
            }
        }
        
        for(int i = 2; i <= n; i++){
            if(!check[i]) answer++;
        }
        
        return answer;
    }
}