package programmers;

public class 문자열다루기기본 {

	public static void main(String[] args) {
		String s = "a234";
		System.out.println(solution(s));
	}

	public static boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) return false;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if('0' <= c && c <= '9') continue;
            
            return false;
        }
        
        return true;
    }
}