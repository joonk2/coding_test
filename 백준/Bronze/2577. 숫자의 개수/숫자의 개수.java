import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        int res = A * B * C;
        int[] cnt = new int[10];
        
        // int형 --> 문자형
        String str_res = String.valueOf(res);
        
        
        for (int i = 0; i < str_res.length(); i++) {
            int num = str_res.charAt(i) - '0';
            cnt[num]++;
        }
        
        
        
        // 결과
        for (int i = 0; i < 10; i ++) {
            System.out.println(cnt[i]);
        }

        
        
        
    }
}