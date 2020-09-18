package programmers;

public class 정수제곱근판별 {

	public static void main(String[] args) {
		long n = 121;
		System.out.println(solution(n));
	}

	public static long solution(long n) {
        long answer = 0;
        
        double x = Math.sqrt(n);
        if(((long)x * (long)x) == n) answer = (long)Math.pow((long)x+1, 2);
        else answer = -1;
        
        return answer;
    }
}