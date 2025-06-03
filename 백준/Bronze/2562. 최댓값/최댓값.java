import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 9;
		int[] num_lst = new int[9];
		int max_val = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(br.readLine());
			num_lst[i] = num;
			if (num > max_val) {
				max_val = num;
			}
		}
		
		
//		System.out.println(Arrays.toString(num_lst));
		
		for (int i = 0; i < num_lst.length; i++) {
			if (max_val == num_lst[i]) {
				System.out.println(max_val);
				System.out.println(i+1);
			}
		}
		

		
		
		
		
	}
}