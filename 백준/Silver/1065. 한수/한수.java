import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

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
                if (digits[0] - digits[1] == digits[1] - digits[2]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);


        
        
    }
    // int --> String
    // charAt() 자체가 Ascii 코드로 자동변환되는게 원칙이라 ex) 1 5 9 라면, '1'-'0' = 49-48
    public static int[] digit_changer(int num) {
        String str = String.valueOf(num);
        int[] digits = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            digits[i] = str.charAt(i) - '0';
        }

        return digits;
    }



}