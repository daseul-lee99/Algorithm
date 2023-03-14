import java.util.*;

class Solution {
    public int[] solution(int[] emergency) {
        // 응급도순으로 정렬(내림차순)한 배열 생성
        List<Integer> emergency_order = new ArrayList<>(emergency.length);
        for(int n : emergency) {
            emergency_order.add(n);
        }
        Collections.sort(emergency_order, Collections.reverseOrder());
        
        // 원래 배열(emergency)에서 응급도를 가져와 정렬된 배열(emergency_order)에서 위치 찾기
        int[] answer = new int[emergency.length];
        int i = 0;
        for(int n : emergency) {
            int pos = emergency_order.indexOf(n) + 1;
            answer[i++] = pos;
        }
        return answer;
    }
}