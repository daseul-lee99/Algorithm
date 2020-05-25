package programmers;

public class 짝수와홀수 {

	public static void main(String[] args) {
		int num = 3;
		System.out.println(solution(num));
	}

	public static String solution(int num) {
        String answer = num%2==0 ? "Even" : "Odd";
        return answer;
    }
}