// answer 1
class Solution {
    public int solution(int[] numbers, int k) {
        int last = numbers.length;
        
        int answer = 1; // 한 번도 안 던졌을 때 1번(k == 1)
        while(--k != 0) {
            int tmp = answer + 2; // 한 칸 건너뛰고 던지니까 +2
            answer = (tmp > last) ? (tmp - last) : (tmp); // 마지막 번호 다음은 1번이니까 마지막 번호보다 클 경우 계산
        }
        return answer;
    }
}


// answer 2
class Solution {
    public int solution(int[] numbers, int k) {
        int last = numbers.length;

        // 던질때마다 2씩 증가하니까 *2 -> 마지막 번호 다음은 1번이니까 마지막 번호로 나눈 나머지 계산
        // 한 번도 안 던졌을 때 1번(numbers[0] == 1) 
        int answer = numbers[((k - 1) * 2) % last];
        return answer;
    }
}