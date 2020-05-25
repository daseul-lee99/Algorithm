package programmers;

public class 문자열내p와y의개수 {

	public static void main(String[] args) {
		String s = "pPoooyY";
		System.out.println(solution(s));
	}

	static boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        int n_p = 0, n_y = 0;
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c=='p') n_p++;
            else if(c=='y') n_y++;
        }
        
        if(n_p==n_y) answer = true;
        else answer = false;

        return answer;
    }
}