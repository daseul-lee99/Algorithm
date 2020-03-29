package programmers;

public class N_number_Game {
    public static void main(String[] args){
        System.out.println(solution(2, 4, 2, 1));
    }

    public static String convert(int n, int num){
        if(num==0) return "0";

        String s = "";
        while(num>0){
            int rest = num%n;
            if(rest>=10) s+=(char)(65+(rest-10));
            else s+=Integer.toString(num%n);

            num /= n;
        }

        return new StringBuffer(s).reverse().toString();
    }

    public static String solution(int n, int t, int m, int p) {
        int max_len = 1000*100;
        String s = "";
        int num = 0;
        while(s.length()<max_len){
            s+=convert(n, num++);
        }

        String answer = "";
        int order = 0;
        for(int i = 0; i < max_len; i++){
            order++;

            if(order==p) {
                answer+=s.charAt(i);
                if(answer.length()==t) break;
            }

            if(order==m) order = 0;
        }

        answer = answer.toUpperCase();
        return answer;
    }
}