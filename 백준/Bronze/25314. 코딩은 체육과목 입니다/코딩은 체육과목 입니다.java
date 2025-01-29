import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int cnt_long = N / 4;
		
		for (int i = 0; i < cnt_long; i++) {
			sb.append("long ");
		}
		sb.append("int");
		
		System.out.println(sb.toString());
		
	}
}