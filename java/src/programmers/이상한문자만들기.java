package programmers;

public class 이상한문자만들기 {

	public static void main(String[] args) {
		String s = "try hello world";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
        String answer = "";
        
        int idx = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') {
                answer += " ";
                idx = 0;
            }
            else{
                if(idx%2 == 0) answer += (c + "").toUpperCase();
                else answer += (c + "").toLowerCase();
                idx++;
            }
        }
        
        return answer;
    }
}