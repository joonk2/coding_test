import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		int Q = Integer.parseInt(br.readLine());
		
		int[][] arr = new int[N][N];
		long[][] DP = new long[N-K+1][N-K+1];
		long max_val = 0;
		
		for (int q = 0; q < Q; q++) {
			String[] rcv = br.readLine().split(" ");
			int r = Integer.parseInt(rcv[0]);
			int c = Integer.parseInt(rcv[1]);
			int v = Integer.parseInt(rcv[2]);
			
			r--;
			c--;
			
			// 변화량
			int delta = v - arr[r][c];
			arr[r][c] = v;
			
			// 시작점과 끝점
			int sr = Math.max(0, r-K+1);
			int sc = Math.max(0, c-K+1);
			int er = Math.min(r, N-K);
			int ec = Math.min(c, N-K);
			
			for (int i = sr; i <= er; i++) {
				for (int j = sc; j <= ec; j++) {
					DP[i][j] += delta;
					max_val = Math.max(max_val, DP[i][j]);
				}
			}
			System.out.println(max_val);
		}
		
	}
}