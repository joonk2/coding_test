import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] s_arr = br.readLine().split(" ");
		int N = Integer.parseInt(s_arr[0]);
		int M = Integer.parseInt(s_arr[1]);
		
		int[] basket = new int[N+1];
		for (int i = 1; i < N+1; i++) {
			basket[i] = i;
		}
		
		for (int k = 0; k < M; k++) {
			String[] arr = br.readLine().split(" ");
			int i = Integer.parseInt(arr[0]);
			int j = Integer.parseInt(arr[1]);
			
			int temp = basket[i];
			basket[i] = basket[j];
			basket[j] = temp;
		}
		br.close();
		
		for (int i = 1; i < N+1; i++) {
			sb.append(basket[i] + " ");
		}
		
		System.out.println(sb.toString().trim());
		
		
		
		
	}
}