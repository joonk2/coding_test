import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] day_value = br.readLine().split(" ");
			int day = Integer.parseInt(day_value[0]);
			int value = Integer.parseInt(day_value[1]);
			arr[i][0] = day;
			arr[i][1] = value;
		}
		
		// recursive_formula
		int[] DP = new int[N+1];
		for (int i = 0; i < N; i++) {
			int day = arr[i][0];
			int value = arr[i][1];
			
			DP[i+1] = Math.max(DP[i], DP[i+1]);
			if (i + day <= N) {
				DP[i+day] = Math.max(DP[i+day], DP[i] + value);
			}
			
		}
		
		// result
		System.out.println(DP[N]);
	}
}