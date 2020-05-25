package programmers;

import java.util.*;

public class 최대공약수와최소공배수 {

	public static void main(String[] args) {
		int n = 3, m = 12;
		
		int[] res = solution(n, m);
		System.out.println(Arrays.toString(res));
	}

	public static int[] solution(int n, int m) {
        int[] answer = {};
        
        if(n==1 || m==1){
            answer = new int[]{1, n*m};
        }
        else{
            int nn = n, nm = m;
            while(nm!=0){
                int r = nn%nm;
                nn = nm;
                nm = r;
            }
            int gcd = nn;
            int lcm = n * m / gcd;
            answer = new int[]{gcd, lcm};
        }
        
        return answer;
    }
}