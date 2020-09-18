package programmers;

public class 하샤드수 {

	public static void main(String[] args) {
		int x = 10;
		System.out.println(solution(x));
	}

	public static boolean solution(int x) {
        boolean answer = true;
        
        int nx = x, sum = 0;
        while(nx!=0){
            sum += nx%10;
            nx /= 10;
        }
        
        answer = x%sum == 0 ? true : false;
        return answer;
    }
}