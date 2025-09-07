import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] T = new int[N];
		int[] P = new int[N];
		for (int i = 0; i < N; i++) {
			String[] TP = br.readLine().split(" ");
			T[i] = Integer.parseInt(TP[0]);
			P[i] = Integer.parseInt(TP[1]); 
		}
		
		int max_profit = 0;
		for (int mask = 0; mask < (1<<N); mask++) {
			int temp_sum_profit = 0;
			int start_day_available = -1;
			for (int bit = 0; bit < N; bit++) {
				if ( (mask & (1<<bit)) != 0 ) {
					if (start_day_available < bit) {
						if (bit + T[bit] < N+1) {
							start_day_available = bit + T[bit] -1;
							temp_sum_profit += P[bit];
						}
					}
					
				}
			}
			max_profit = Math.max(max_profit, temp_sum_profit);
		}
		System.out.println(max_profit);
	}
}