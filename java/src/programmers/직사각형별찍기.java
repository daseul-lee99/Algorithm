package programmers;

import java.util.*;

public class 직사각형별찍기 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 3
        int b = sc.nextInt(); // 5
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < b; i++){
            for(int j = 0; j < a; j++) sb.append("*");
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

}
