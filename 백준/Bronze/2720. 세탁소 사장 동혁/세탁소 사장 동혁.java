import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			int money = Integer.parseInt(br.readLine());
			
			int[] changes = {25,10,5,1};
			
			int remainder = money;
			StringBuilder sb = new StringBuilder();
			for (int j : changes) {
				int mod = remainder / j;
				sb.append(mod + " ");
				remainder %= j;
			}
			
			System.out.println(sb.toString());
			
			
		}
		
		
	}
}