package programmers;

public class 스킬체크테스트level2_2 {
	public static int[] res;
	public static String ans;
	
	public static void main(String[] args) throws Exception{
		String answer = solution(new int[] {6, 10, 2});
		System.out.print(answer);
	}
	
	public static String solution(int[] numbers) {
		String answer = "";
		
		res = new int[numbers.length];
		ans = "0";
		boolean[] v = new boolean[numbers.length];
		comb(0, numbers, v);
		
		answer = ans;
		return answer;
	}
	
	public static void comb(int lv, int[] numbers, boolean[] v) {
		if(lv==numbers.length) {
			String tmp = "";
			for(int i : res) tmp += String.valueOf(i);
			
			if(Integer.parseInt(ans) < Integer.parseInt(tmp)) ans = tmp;
			
			return;
		}
		
		for(int i = 0; i < numbers.length; i++) {
			if(!v[i]) {
				v[i] = true;
				res[lv] = numbers[i];
				comb(lv+1, numbers, v);
				v[i] = false;
			}
		}
	}
}