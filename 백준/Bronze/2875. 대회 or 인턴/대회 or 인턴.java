import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static int N,M,K, ans;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String[] s_arr = S.split(" ");
		N = Integer.parseInt(s_arr[0]);
		M = Integer.parseInt(s_arr[1]);
		K = Integer.parseInt(s_arr[2]);
		
		ans = 0;
		while (N >= 2 && M >= 1 && (N+M)-K >= 3) {
			ans++;
			N -= 2;
			M--;
		}
		
		System.out.println(ans);
		
		
		
		
	}
}