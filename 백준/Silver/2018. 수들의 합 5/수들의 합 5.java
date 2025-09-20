import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		case_number();
	}
	
	static void case_number() {
		int cnt = 0;
		int sum = 0;
		int s = 1;
		int e = 1;
		
		while (s <= N) {
			if (sum == N) {
				cnt++;
			}
			
			
			if (sum < N) {
				sum += e;
				e++;
			}
			else if (sum >= N) {
				sum -= s;
				s++;
			}
			
		}
		System.out.println(cnt);
	}
	
	
	
}