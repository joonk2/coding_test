//한수
//숫자 3자리 abc라고 할 때 a-b = b-c 여야함
//100미만 한수 -> 1~99 


//210개의 한수
//1~99 + 111, 123, 135, 147, 159, 210 --> 총 105개
//매우 중요 ! --> 정수는 인덱스로 접근할 수 없다  (문자열 변환이 필요하겠네?)


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        
        for (int i = 1; i <= N; i++) {
            if (i < 100) {
                cnt++;
            }
            else if (i >= 100 && i < 1000) {
                int[] digits = digit_changer(i);
                if (digits[0] - digits[1] == digits[1]-digits[2]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
        
        
    }
    
    
    
    public static int[] digit_changer(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }
        return digits;
        
    }
    
    
}
