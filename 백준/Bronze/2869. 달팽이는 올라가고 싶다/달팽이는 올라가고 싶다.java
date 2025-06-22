import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] ABV = br.readLine().split(" ");
		int A = Integer.parseInt(ABV[0]);
		int B = Integer.parseInt(ABV[1]);
		int V = Integer.parseInt(ABV[2]);
		
		
// ---------- 내가 시도한 틀린 방법 (시간 초과) ------------
//		int cnt = 0;
//		int sum = 0;
//		while (sum < V) {
//			cnt++;
//			sum += A;
//			if (sum >= V) break;
//			sum -= B;
//			if (sum >= V) break;	
//		}
//		System.out.println(cnt);
		
		
		
		int day = (int) Math.ceil((double) (V-B) / (A-B) );
		System.out.println(day);
		
		
		
	}
}