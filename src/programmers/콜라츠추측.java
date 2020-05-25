package programmers;

public class 콜라츠추측 {

	public static void main(String[] args) {
		int num = 626331;
		System.out.println(solution(num));
	}

	public static int solution(int num) {
        int answer = 0;
        
        long nnum = num;
        while(nnum!=1){
            if(nnum%2==0) nnum /= 2;
            else nnum = nnum * 3 + 1;
            
            answer++;
            if(answer>500) {
                answer = -1;
                break;
            }
        }
        
        return answer;
    }
}