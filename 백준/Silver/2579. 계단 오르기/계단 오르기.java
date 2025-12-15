import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int N;
	static int[] arr;
	static int[][] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		DP = new int[N+1][3];
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			arr[i+1] = num;
		}
		
		lets_find_max_val();
	}
	
	
	
	
	static void lets_find_max_val() {
		// 첫계단
		DP[1][1] = arr[1];
		
		// 두번째 계단
		// [1] 전계단 안 밟음
		// [2] 전계단 밟음
		if (N >= 2) {
			DP[2][1] = arr[2];
			DP[2][2] = arr[1] + arr[2];
		}
		
		for (int i = 3; i < N+1; i++) {
			DP[i][1] = Math.max(DP[i-2][1], DP[i-2][2]) + arr[i];
			DP[i][2] = DP[i-1][1] + arr[i];
		}
		
		
		System.out.println(Math.max(DP[N][1], DP[N][2]));
	}
	
	
}