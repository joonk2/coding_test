import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			int N = Integer.parseInt(br.readLine());
			String[] s_arr = br.readLine().split(" ");
			int[] arr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(s_arr[i]);
			}
			
			int max_price = arr[N-1];
			long sum = 0;
			for (int i = N-2; i >= 0; i--) {
				if (arr[i] > max_price) {
					max_price = arr[i];
				}
				else if (arr[i] <= max_price) {
					sum += max_price - arr[i];
				}
			}
			System.out.println(sum);
			
		}
		
	}
}