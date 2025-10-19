import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		
		// K개의 바구니에 모두 다르면서 1이상으로 넣기 위한 공의 최소 갯수
		int minSum = K * (K+1) / 2;
		
		if (N < minSum) {
			System.out.println(-1);
		} else {
			int remain = N - minSum;
			if (remain % K == 0) {
				System.out.println(K - 1);
			} else {
				System.out.println(K);
			}
		}
		
	}
}