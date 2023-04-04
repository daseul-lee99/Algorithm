class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int size = (len + n - 1) / n;
        String[] answer = new String[size];
        
        for(int i = 0; i < size; i++) {
            int st = i * n;
            int ed = (st + n) > len ? len : (st + n);
            
            answer[i] = my_str.substring(st, ed);
        }
        
        return answer;
    }
}