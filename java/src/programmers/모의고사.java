package programmers;

import java.util.*;

public class 모의고사 {

	public static void main(String[] args) {
		int[] answers = {1,3,2,4,2};
		
		int[] res = solution(answers);
		for(int val : res) {
			System.out.print(val + " ");
		}
	}
	
    public static int[] solution(int[] answers) {
    	int[] answer = {};
        
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        
        int point1 = 0, point2 = 0, point3 = 0;
        for(int i = 0; i < answers.length; i++){
            if(answers[i]==one[i%one.length]) point1++;
            if(answers[i]==two[i%two.length]) point2++;
            if(answers[i]==three[i%three.length]) point3++;
        }
        
        int max = Math.max(Math.max(point1, point2), point3);
        Stack<Integer> tmp_answer = new Stack<>();
        if(point1==max) tmp_answer.push(1);
        if(point2==max) tmp_answer.push(2);
        if(point3==max) tmp_answer.push(3);
        
        answer = new int[tmp_answer.size()];
        for(int i = tmp_answer.size()-1; i >= 0; i--){
            answer[i] = tmp_answer.pop();
        }
        return answer;
    }
}