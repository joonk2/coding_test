import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		long N = Long.parseLong(NK[0]);
		long K = Long.parseLong(NK[1]);
		C(N, K);
	}
	
	
	static void C(long N, long K) {
		// 초기 배열 크기 선언
		long[][] DP = new long[(int)N+1][(int)N+1];
		
		// 1중 반복문
		for (int i = 0; i < N+1; i++) {
			// i개중 0개 고르기 -> 1
			DP[i][0] = 1;
			
			// i개중 1개 고르기 -> i
			DP[i][1] = i;
			
			// i개중 i개 고르기 -> 1
			DP[i][i] = 1;
		}
		

		
		// 채우기 -> DP pascal (2중 반복문)
		// c는 r을 넘으면 안된다
		for (int r = 3; r < N+1; r++) {
			for (int c = 2; c < r; c++) {
				DP[r][c] = (DP[r-1][c-1] + DP[r-1][c]) % 10007;
			}
		}
		
		
		
		long res = DP[(int)N][(int)K];
		System.out.println(res);
	}
	
	
	
}