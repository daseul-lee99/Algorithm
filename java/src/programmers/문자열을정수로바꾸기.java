package programmers;

public class 문자열을정수로바꾸기 {

	public static void main(String[] args) {
		String s = "1234";
		System.out.println(solution(s));
	}

	public static int solution(String s) {
        int answer = 0;
        
        char c = s.charAt(0);
        if(c=='+' || c=='-'){
            answer = Integer.parseInt(s.substring(1));
            
            if(c=='-') answer *= -1;
        }
        else answer = Integer.parseInt(s);
        
        return answer;
    }
}