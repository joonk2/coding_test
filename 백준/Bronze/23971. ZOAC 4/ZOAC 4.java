import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] S = br.readLine().split(" ");
        int H = Integer.parseInt(S[0]);
        int W = Integer.parseInt(S[1]);
        int N = Integer.parseInt(S[2]);
        int M = Integer.parseInt(S[3]);

        System.out.println(Solution(H, W, N, M));
    }

    
    
    
    
    public static int Solution(int H, int W, int N, int M) {
        int x = (H + N) / (N + 1);
        int y = (W + M) / (M + 1);
        return x * y;
    }

    
    
    
    
}