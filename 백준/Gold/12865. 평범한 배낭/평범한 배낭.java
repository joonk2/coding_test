import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		int[][] arr = new int[N][2];
		for (int i = 0; i < N; i++) {
			String[] W_V = br.readLine().split(" ");
			int W = Integer.parseInt(W_V[0]);
			int V = Integer.parseInt(W_V[1]);
			arr[i][0] = W;
			arr[i][1] = V;
		}
		
		int[] DP = new int[K+1];
		for (int i = 0; i < N; i++) {
			int weight = arr[i][0];
			int value = arr[i][1];
			for (int w = K; w >= weight; w--) {
				DP[w] = Math.max(DP[w], DP[w-weight] + value);
			}
		}
		
		System.out.println(DP[K]);
	}

}