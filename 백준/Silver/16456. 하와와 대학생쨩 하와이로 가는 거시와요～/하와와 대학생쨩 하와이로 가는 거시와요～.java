import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if (N == 1) {
			System.out.println(1);
			return;
		}
		if (N == 2) {
			System.out.println(1);
			return;
		}
		if (N == 3) {
			System.out.println(2);
			return;
		}
		
		int[] DP = new int[N+1];
		DP[1] = 1;
		DP[2] = 1;
		DP[3] = 2;
		
		for (int i = 4; i < N+1; i++) {
			DP[i] = (DP[i-1] + DP[i-3]) % 1000000009;
		}
		System.out.println(DP[N]);
	}
}