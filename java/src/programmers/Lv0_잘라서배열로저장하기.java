class Solution {
    public String[] solution(String my_str, int n) {
        int len = my_str.length();
        int size = (len + n - 1) / n; // n 길이 미만의 문자열이 나올 수 있으니까 + (n - 1)
        String[] answer = new String[size];
        
        for(int i = 0; i < size; i++) {
            int st = i * n;
            int ed = (st + n) > len ? len : (st + n);
            
            answer[i] = my_str.substring(st, ed); // st번째 문자 포함, ed번째 문자 미포함 [st, ed)
        }
        
        return answer;
    }
}