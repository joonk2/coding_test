import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] s_arr = br.readLine().split(" ");
		int v = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		int cnt = 0;
		
		for (int i = 0; i < s_arr.length; i++) {
			arr[i] = Integer.parseInt(s_arr[i]);
			if (arr[i] == v) {
				cnt++;
			}
		}
		
		System.out.println(cnt);
		
	}
}