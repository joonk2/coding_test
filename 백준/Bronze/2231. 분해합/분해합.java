import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int res = find_smallest_num(N);
		System.out.println(res);
	}
	
	public static int find_smallest_num(int N) {
		int res = 0;
		for (int i = 1; i < 1000001; i++) {
			int temp_val = i;
			int temp_sum = 0;
			String temp_num = String.valueOf(i);
			for (int j = 0; j < temp_num.length(); j++) {
				int k = temp_num.charAt(j)-'0';
				temp_sum += k;
			}
			if (temp_val + temp_sum == N) {
				res = temp_val;
			}
			
			if (temp_val + temp_sum == N) {
				break;
			}
			
		}
		return res;
		
	}
	
}