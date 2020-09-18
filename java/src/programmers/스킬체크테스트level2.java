package programmers;

public class 스킬체크테스트level2 {
	public static void main(String[] args) throws Exception{
		int[] answer = solution(new int[] {1, 2, 3, 2, 3});
		
		for(int i : answer) System.out.print(i + " ");
	}
	
	public static int[] solution(int[] prices) {
		int[] answer = new int[prices.length];
		
		boolean[] check = new boolean[prices.length];
		for(int i = 1; i < prices.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(!check[j]) {
					answer[j]++;
					if(prices[j] > prices[i]) check[j] = true;
				}
			}
		}
		
		return answer;
	}
}