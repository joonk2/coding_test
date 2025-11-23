import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] nk = br.readLine().split(" ");
		int n = Integer.parseInt(nk[0]);
		int k = Integer.parseInt(nk[1]);
		
		// 조기 종료
		if (n <= 2) {
			System.out.println(1);
			return;
		}
		
		pascal_triangle(n, k);
	}
	
	
	
	static void pascal_triangle(int n, int k) {
		int[][] DP = new int[n+1][n+1];
		DP[1][1] = 1;
		DP[2][1] = 1;
		DP[2][2] = 1;
		
		for (int i = 3; i < n+1; i++) {
			DP[i][1] = 1;
			DP[i][i] = 1;
		}
		
		
		// formula
		// c는 r보다 범위가 반드시 작을 것
		for (int r = 3; r < n+1; r++) {
			for (int c = 2; c < r; c++) {
				DP[r][c] = DP[r-1][c-1] + DP[r-1][c];
			}
		}
		
		
		// answer
		System.out.println(DP[n][k]);
	}
	
	
	
	
	
}