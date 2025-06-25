import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int[] x = new int[N];
		int[] y = new int[N];
		int min_x = Integer.MAX_VALUE;
		int min_y = Integer.MAX_VALUE;
		int max_x = Integer.MIN_VALUE;
		int max_y = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			String[] ab = br.readLine().split(" ");
			int a = Integer.parseInt(ab[0]);
			int b = Integer.parseInt(ab[1]);
			x[i] = a;
			y[i] = b;
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		for (int i = 0; i < N; i++) {
			if (min_x > x[i]) {
				min_x = x[i];
			}
			if (min_y > y[i]) {
				min_y = y[i];
			}
			if (max_x < x[i]) {
				max_x = x[i];
			}
			if (max_y < y[i]) {
				max_y = y[i];
			}
		}
		
		int target_x = 0;
		int target_y = 0;
		
		target_x = (max_x - min_x);
		target_y = (max_y - min_y);
		System.out.println(target_x * target_y);
		
//		System.out.println(Arrays.toString(x));
//		System.out.println(Arrays.toString(y));
		
	}
}