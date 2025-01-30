import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static long N, max, min;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Long.parseLong(br.readLine());
		String[] s_arr = br.readLine().split(" ");
		
		max = Long.MIN_VALUE;
		min = Long.MAX_VALUE;
		
		for (int i = 0; i < s_arr.length; i++) {
			long num = Long.parseLong(s_arr[i]);
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
        br.close();
		
		sb.append(min).append(" ").append(max);
		System.out.println(sb);
		
		
		
		
	}
}