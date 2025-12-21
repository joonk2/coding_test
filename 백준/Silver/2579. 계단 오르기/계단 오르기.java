import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class Main {
	static int N;
	static int[] arr;
	static int[] DP;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1];
		DP = new int[N+1];
		for (int i = 0; i < N; i++) {
			arr[i+1] = Integer.parseInt(br.readLine());
		}
		
		lets_find_max_val();
	}
	
	
	
	
	static void lets_find_max_val() {
		if (N == 1) {
			DP[1] = arr[1];
			System.out.println(DP[1]);
			return;
		}
		if (N == 2) {
			DP[2] = arr[1] + arr[2];
			System.out.println(DP[2]);
			return;
		}
		if (N == 3) {
			DP[3] = Math.max(arr[1] + arr[2], Math.max(arr[1] + arr[3], arr[2] + arr[3]));
			System.out.println(DP[3]);
			return;
		}
		
		DP[1] = arr[1];
		DP[2] = arr[1] + arr[2];
		DP[3] = Math.max(arr[1] + arr[3], arr[2] + arr[3]);
		
		
		for (int i = 4; i < N+1; i++) {
			DP[i] = Math.max(arr[i] + DP[i-2], arr[i] + arr[i-1] + DP[i-3]);
		}
		System.out.println(DP[N]);
		
	}
	
	
}