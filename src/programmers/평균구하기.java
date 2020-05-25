package programmers;

public class 평균구하기 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		System.out.print(solution(arr));
	}

	public static double solution(int[] arr) {
        double answer = 0;
        
        int sum = 0;
        for(int i : arr) sum += i;
        
        answer  = sum / (double)arr.length;
        return answer;
    }
}