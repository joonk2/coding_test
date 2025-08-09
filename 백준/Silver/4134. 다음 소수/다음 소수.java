import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		
		StringBuilder sb = new StringBuilder();
		for (int tc = 1; tc < T+1; tc++) {
			long N = Long.parseLong(br.readLine());
			if (N <= 2) {
				N = 2;
				sb.append(N).append("\n");
			}
			else {
				while (!is_prime(N)) {
					N++;
				}
				sb.append(N).append("\n");
			}
		}
		System.out.print(sb.toString());
	
		
	}
	
	
	
	public static boolean is_prime(long N) {
		if (N <= 1) return false;
		if (N == 2) return true;
		if (N % 2 == 0) return false;
		
		long sqrt = (long) Math.sqrt(N);
		for (long i = 3; i < sqrt + 1; i += 2) {
			if (N % i == 0) return false;
		}
		return true;
	}
	
	
	
	
	
	
	
	
}