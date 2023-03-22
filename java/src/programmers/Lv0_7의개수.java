class Solution {
    public int solution(int[] array) {
        // int 배열을 하나의 문자열로 변환
        String s = "";
        for(int i : array) s += i;
        
        // 7 외의 숫자를 ""로 변환
        s = s.replaceAll("[^7]", "");
        
        int answer = s.length();
        return answer;
    }
}