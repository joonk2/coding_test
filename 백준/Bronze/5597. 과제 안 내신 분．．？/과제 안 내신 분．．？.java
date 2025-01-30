import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		boolean[] submitted = new boolean[31];
		for (int i = 1; i < 29; i++) {
			int num = Integer.parseInt(br.readLine());
			submitted[num] = true;
		}
		
		for (int i = 1; i < 31; i++) {
			if (submitted[i] == false) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
		
		
	}
}