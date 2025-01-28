import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		for (int i = N; i > 0; i--) {
			String[] s_arr = br.readLine().split(" ");
			long a = Long.parseLong(s_arr[0]);
			int b = Integer.parseInt(s_arr[1]);
			sum += (a*b);
		}
		
		if (X == sum) {
			System.out.println("Yes");
		}
		else {
			System.out.println("No");
		}
		
	}
}