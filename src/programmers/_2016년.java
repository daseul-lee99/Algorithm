package programmers;

public class _2016년 {

	public static void main(String[] args) {
		int a = 5, b = 24;
		
		System.out.println(solution(a, b));
	}
	
	public static String solution(int a, int b) {
        String answer = "";
        
        int[] num_days = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int all_days = b - 1;
        for(int i = 1; i < a; i++) all_days += num_days[i-1];
        
        answer = day[all_days % 7];
        
        return answer;
    }
}