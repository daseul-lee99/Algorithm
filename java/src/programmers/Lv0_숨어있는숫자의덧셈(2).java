// answer 1
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String tmp = "";
        for(char c : my_string.toCharArray()) {
            // 문자가 나올 때까지 숫자 연결
            if('0' <= c && c <= '9') tmp += c;
            else if(tmp.length() != 0) { // 문자가 나오면 숫자 더하기
                answer += Integer.parseInt(tmp);
                tmp = "";
            }
        }
        
        if(tmp.length() != 0) answer += Integer.parseInt(tmp);
        
        return answer;
    }
}


// answer 2
class Solution {
    public int solution(String my_string) {
        // 숫자가 아니면 " " 공백으로 변환 후 공백 기준으로 split
        String[] tmp = my_string.replaceAll("[^0-9]", " ").split(" ");

        int answer = 0;
        for(String s : tmp) {
            if(!s.equals("")) answer += Integer.parseInt(s);
        }
        return answer;
    }
}