package programmers;

public class 핸드폰번호가리기 {

	public static void main(String[] args) {
		String phone_number = "01033334444";
		System.out.println(solution(phone_number));
	}

	public static String solution(String phone_number) {
        String answer = "";
        
        int len = phone_number.length();
        for(int i = 0; i < len-4; i++) answer += "*";
        answer += phone_number.substring(len - 4);
        
        return answer;
    }
}