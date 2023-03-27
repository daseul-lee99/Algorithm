class Solution {
    public long solution(String numbers) {
        String[] digit = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for(int i = 0; i <= 9; i++) {
            numbers = numbers.replaceAll(digit[i], i + "");
        }
        
        long answer = Long.valueOf(numbers);
        return answer;
    }
}