import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i < N+1; i++) {
			StringBuilder sb = new StringBuilder();
			for (int j = 1; j < N-i+1; j++) {
				sb.append(" ");
			}
			for (int j = 1; j < i+1; j++) {
				sb.append("*");
			}
			
			
			System.out.println(sb.toString());
		}
		
		
	}
}