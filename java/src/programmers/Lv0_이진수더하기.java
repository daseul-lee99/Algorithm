// answer 1
class Solution {
    public String solution(String bin1, String bin2) {
        // 2진수 input을 10진수 int로 변환
        int ibin1 = Integer.parseInt(bin1, 2);
        int ibin2 = Integer.parseInt(bin2, 2);
        
        // 변환한 두 수를 더한 후, 다시 2진수로 변환
        String answer = Integer.toBinaryString(ibin1 + ibin2);
        return answer;
    }
}


// answer 2
class Solution {
    public String solution(String bin1, String bin2) {
        // input 2진수 앞에 0을 채워 11자리 문자열로 만듦
        String s_bin1 = String.format("%011d", Integer.parseInt(bin1));
        String s_bin2 = String.format("%011d", Integer.parseInt(bin2));
        
        String answer = "";
        int d = 0; // 올림수를 저장할 변수
        for(int i = s_bin1.length() - 1; i >= 0; i--) {
            int a = s_bin1.charAt(i) - '0';
            int b = s_bin2.charAt(i) - '0';
            int c = a + b + d;
            
            // 2진수라 2가 넘는 경우 처리
            // 올림수(d)까지 더했을 때 3이 되는 경우도 있으므로 -2 연산
            if(c >= 2) {
                c -= 2;
                d = 1;
            } else { d = 0; }
            
            answer = c + answer; 
        }
        
        // 10자리 2진수를 연산했을 때 결과값이 11자리 2진수가 나오는 경우도 있으므로 마지막 올림수 확인
        if(d != 0) answer = d + answer;
        
        // Integer.MAX_VALUE: 2,147,483,647
        // Long.MAX_VALUE: 9,223,372,036,854,775,807
        // Integer.parseInt() 사용 시 error
        if(!answer.equals("")) answer = Long.parseLong(answer) + "";
        return answer;
    }
}