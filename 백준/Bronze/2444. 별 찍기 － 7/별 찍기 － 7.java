import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());


        
        for (int i = 0; i < N; i++) {
            sb.append(" ".repeat(N-i-1)).append("*".repeat(2*i +1)).append('\n');
        }

        
        
        for (int i = 0; i < N-1; i++) {
            sb.append(" ".repeat(i+1)).append("*".repeat( (N-i-1)*2 -1) ).append('\n');
        }

        
        
        System.out.println(sb);

    }
}