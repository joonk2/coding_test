import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;



public class Solution {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc < T+1; tc++) {
			String[] arr = br.readLine().split(" ");
			
			int h1 = Integer.parseInt(arr[0]);
			int m1 = Integer.parseInt(arr[1]);
			int h2 = Integer.parseInt(arr[2]);
			int m2 = Integer.parseInt(arr[3]);
			
			
			int temp_h = (h1 + h2) % 12;
			int extra_h = (m1 + m2) / 60;
			int final_m = (m1 + m2) % 60;
			
			int final_h = (temp_h + extra_h) % 12;
			if (final_h == 0) final_h = 12;
			
			
			System.out.println("#" + tc + " " + final_h + " " + final_m);
			
			
		}
		
		
	}
}