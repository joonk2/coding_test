import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int i = 1; i < T+1; i++) {
			String[] s_arr = br.readLine().split(" ");
			int A = Integer.parseInt(s_arr[0]);
			int B = Integer.parseInt(s_arr[1]);
			
			sb.append("Case #" + i + ": " + A + " + " + B + " = " + (A+B) + "\n");	
		}
		
		
		System.out.println(sb);
		br.close();
		
	}
}