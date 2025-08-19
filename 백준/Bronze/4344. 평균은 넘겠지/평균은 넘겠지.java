import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int C = Integer.parseInt(br.readLine());
		for (int i = 0; i < C; i++) {
			String[] items = br.readLine().split(" ");
			double res = my_calculator(items);
			System.out.printf("%.3f%%\n", res);
		}
	}
	
	
	
	
	public static double my_calculator(String[] arr) {
		double avg = 0;
		int sum = 0;
		int N = Integer.parseInt(arr[0]);
		for (int i = 1; i < N+1; i++) {
			sum += Integer.parseInt(arr[i]);
		}
		avg = (double) sum / N;
		
		
		double ratio = 0;
		int cnt = 0;
		for (int i = 1; i < N+1; i++) {
			int temp_val = Integer.parseInt(arr[i]);
			if (temp_val > avg) cnt++;
		}
		ratio = (double) cnt / N * 100;
		return ratio;
	}
	
	
	
	
	
}