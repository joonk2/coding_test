import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String OX = br.readLine();
            int score = 0;
            int sum = 0;

            for (char ch : OX.toCharArray()) {
                if (ch == 'O') {
                    score += 1;
                }
                else {
                    score = 0;
                }
                sum += score;
            }
            
            System.out.println(sum);
            
        }
        
        
    }
}