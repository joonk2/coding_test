import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			long res = what_is_answer(N);
			System.out.println(res);
		}
	} 
	
	
	
	static long what_is_answer(int N) {
		long[] P = new long[N+1];
		if (N == 1) {
			return 1;
		}
		else if (N == 2) {
			return 1;
		}
		else if (N == 3) {
			return 1;
		}
		else if (N == 4) {
			return 2;
		}
		else if (N == 5) {
			return 2;
		}
		else if (N == 6) {
			return 3;
		}
		else if (N >= 7) {
			P[1] = 1;
			P[2] = 1;
			P[3] = 1;
			P[4] = 2;
			P[5] = 2;
			P[6] = 3;
			
			for (int i = 7; i < N+1; i++) {
				P[i] = P[i-5] + P[i-1];
			}
			return P[N];
		}
		
		return 0;
	}
	
	
}