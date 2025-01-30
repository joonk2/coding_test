import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int max = Integer.MIN_VALUE;
		int idx = 0;
		
		for (int i = 0; i < 9; i++) {
			int num = Integer.parseInt(br.readLine());
			
			if (num > max) {
				max = num;
				idx = i+1;
			}
		
		
		}
		
		System.out.println(max);
		System.out.println(idx);
	}
}