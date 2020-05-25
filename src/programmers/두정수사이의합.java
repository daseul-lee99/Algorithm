package programmers;

public class 두정수사이의합 {

	public static void main(String[] args) {
		int a = 3, b = 5;
		System.out.println(solution(a, b));
	}

	public static long solution(int a, int b) {
        long answer = 0;
        
        long min = Math.min(a, b), max = Math.max(a, b);
        answer = (min + max) * (max - min + 1) / 2;
            
        return answer;
    }
}