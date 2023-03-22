class Solution {
    public int solution(int[] array) {
        String s = "";
        for(int i : array) s += i;
        
        s = s.replaceAll("[^7]", "");
        
        int answer = s.length();
        return answer;
    }
}