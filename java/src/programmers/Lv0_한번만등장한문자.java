class Solution {
    public String solution(String s) {
        // 문자가 등장한 수를 카운트할 배열 생성
        int[] cnt = new int[26];
        
        for(char c : s.toCharArray()) cnt[c - 'a']++;
        
        // 카운트가 1인 문자만 체크
        String answer = "";
        for(int i = 0; i < cnt.length; i++) {
            if(cnt[i] == 1) answer += (char)('a' + i);
        }
        
        return answer;
    }
}