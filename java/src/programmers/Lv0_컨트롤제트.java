// answer 1
class Solution {
    public int solution(String s) {
        String[] s_list = s.split(" ");
        int len = s_list.length;
        
        int answer = 0;
        for(int i = 0; i < len; i++) {
            // 현재 문자의 다음에 Z가 있는지 체크하기 위한 범위 체크
            int idx = (i + 1) > (len - 1) ? (len - 1) : (i + 1);

            // 현재 문자가 숫자이고, 다음 문자가 Z가 아니면 더하기
            if(!s_list[i].equals("Z") && !s_list[idx].equals("Z")) {
                answer += Integer.valueOf(s_list[i]);
            }
        }
        return answer;
    }
}


// answer 2
import java.util.*;

class Solution {
    public int solution(String s) {
        String[] s_list = s.split(" ");
        
        // LIFO(Last In First Out) 구조인 Stack 활용
        Stack<Integer> nums = new Stack<>();
        for(String tmp : s_list) {
            if(!tmp.equals("Z")) nums.push(Integer.valueOf(tmp)); // 숫자면 push
            else nums.pop(); // Z면 마지막에 들어간 숫자 pop

        }
        
        int answer = 0;
        while(!nums.isEmpty()) {
            answer += nums.pop();
        }
        return answer;
    }
}