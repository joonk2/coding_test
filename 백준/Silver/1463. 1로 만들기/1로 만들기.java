import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] DP = new int[N+1];
		DP[1] = 0;
		
		for (int i = 2; i < N+1; i++) {
			// 1빼기
			DP[i] = DP[i-1] + 1;
			
			// 2로 나누기
			if (i % 2 == 0) DP[i] = Math.min(DP[i], DP[i/2] + 1);
			
			// 3으로 나누기
			if (i % 3 == 0) DP[i] = Math.min(DP[i], DP[i/3] + 1);
		}
		
		System.out.println(DP[N]);
		
	}
}