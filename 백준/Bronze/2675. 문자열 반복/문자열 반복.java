import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			String[] RS = br.readLine().split(" ");
			int R = Integer.parseInt(RS[0]);
			String S = RS[1];
			
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < S.length(); j++) {
				char ch = S.charAt(j);
				for (int k = 1; k < R+1; k++) {
					sb.append(ch);
				}
			}
			System.out.println(sb);
			
			
		}
		
	}
}