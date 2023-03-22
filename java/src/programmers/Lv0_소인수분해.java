// answer 1
import java.util.*;

class Solution {
    public int[] solution(int n) {
        // 중복값 제외를 위한 Set 변수 사용
        Set<Integer> prime = new LinkedHashSet<Integer>();
        
        int n_cpy = n;
        for(int i = 2; i <= n; i++) {
            // 소수 판별
            boolean b_prime = true;
            for(int j = 2; j < i; j++) {
                if(i % j == 0) {
                    b_prime = false;
                    break;
                }
            }
            
            // 소수가 맞으면
            if(b_prime) {
                // 해당 소수로 나눌 수 있을 때까지 나누기
                while(n_cpy % i == 0) {
                    prime.add(i);
                    n_cpy /= i;
                }
            }
            
            if(n_cpy == 1) break;
        }
        
        int[] answer = new int[prime.size()];
        Iterator<Integer> it = prime.iterator();
        int i = 0;
        while(it.hasNext()) {
            answer[i++] = Integer.valueOf(it.next());
        }
        
        return answer;
    }
}


// answer 2
// answer 1에서 소수 판별 부분 삭제 - 반복해서 나누는 과정에서 소수의 배수 값이 다 걸러지기 때문에 별도의 소수 판별이 필요 없음
import java.util.*;

class Solution {
    public int[] solution(int n) {
        Set<Integer> prime = new LinkedHashSet<Integer>();
        
        int n_cpy = n;
        for(int i = 2; i <= n; i++) {
            while(n_cpy % i == 0) {
                prime.add(i);
                n_cpy /= i;
            }
            
            if(n_cpy == 1) break;
        }
        
        int[] answer = new int[prime.size()];
        Iterator<Integer> it = prime.iterator();
        int i = 0;
        while(it.hasNext()) {
            answer[i++] = Integer.valueOf(it.next());
        }
        
        return answer;
    }
}