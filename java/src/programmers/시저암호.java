package programmers;

public class 시저암호 {

	public static void main(String[] args) {
		String s = "AB";
		int n = 1;
		System.out.println(solution(s, n));
	}

	public static String solution(String s, int n) {
        String answer = "";
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ') answer += " ";
            else {
                if('a'<=c && c<='z') {
                    int nn = s.charAt(i) + n;
                    if(nn>'z') nn -= ('z' - 'a' + 1);
                    answer += (char) nn;
                }
                else if('A'<=c && c<='Z') {
                    int nn = s.charAt(i) + n;
                    if(nn>'Z') nn -= ('Z' - 'A' + 1);
                    answer += (char) nn;
                }
            }
        }
        
        return answer;
    }
}