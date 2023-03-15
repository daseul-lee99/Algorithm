// answer 1
class Solution {
    public int solution(String my_string) {
        int answer = 0;
        
        String tmp = "";
        for(char c : my_string.toCharArray()) {
            System.out.println("c: " + c);
            if('0' <= c && c <= '9') tmp += c;
            else if(tmp.length() != 0) {
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
        String[] tmp = my_string.replaceAll("[^0-9]", " ").split(" ");

        int answer = 0;
        for(String s : tmp) {
            if(!s.equals("")) answer += Integer.parseInt(s);
        }
        return answer;
    }
}