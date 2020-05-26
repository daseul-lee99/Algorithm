package programmers;

public class 비밀지도 {

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = {9, 20, 28, 18, 11}, arr2 = {30, 1, 21, 17, 28};
		
		String[] res = solution(n, arr1, arr2);
		for(String s: res) System.out.println(s);
	}

	public static String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i < n; i++){
            answer[i] = findMap(arr1[i], arr2[i], n);
        }
        
        return answer;
    }
    
    public static String findMap(int a, int b, int n){
        String binar = String.format("%" + n + "s", Integer.toBinaryString(a | b));
        binar = binar.replaceAll("1", "#");
        binar = binar.replaceAll("0", " ");
        
        return binar;
    }
}
