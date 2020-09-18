package programmers;

public class 가운데글자가져오기 {

	public static void main(String[] args) {
		String s = "abcde";
		System.out.println(solution(s));
		
	}
	
	public static String solution(String s) {
        String answer = "";
        
        int len = s.length();
        answer = s.substring((len-1)/2, len/2+1);
        
        return answer;
    }
}