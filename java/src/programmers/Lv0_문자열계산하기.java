class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split(" ");

        int answer = Integer.valueOf(str[0]); // 처음은 항상 숫자니까 넣고 시작
        for(int i = 1; i < str.length; i+=2) { // 연산자, 숫자 순으로 볼거라 2씩 증가
            String oper = str[i]; // + 또는 -
            int n = Integer.valueOf(str[i + 1]); // 연산자 다음은 항상 숫자
            
            if(oper.equals("+")) answer += n;
            else answer -= n;
        }
        
        return answer;
    }
}