import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = 42;
		boolean[] checked = new boolean[42];
		
		int[] box = new int[10+1];
		int cnt = 0;
		for (int i = 0; i < 10; i++) {
			int num = Integer.parseInt(br.readLine());
			int target_num = (num % 42);
			if (!checked[target_num]) {
				box[i] = i;
				checked[target_num] = true;
				cnt++;
			}
			
		}
		
//		System.out.println(Arrays.toString(checked));
		System.out.println(cnt);
		
	}
}