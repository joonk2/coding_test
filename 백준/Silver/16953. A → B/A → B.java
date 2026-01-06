import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
	static long cnt_min = Long.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] AB = br.readLine().split(" ");;
		long A = Long.parseLong(AB[0]);
		long B = Long.parseLong(AB[1]);
		back_tracking(A, B, 1);
		
		// result
		if (cnt_min == Long.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		System.out.println(cnt_min);
		
	}
	
	
	
	
	static void back_tracking(long start, long end, long cur_cnt) {
		// pruning-a
		if (start == end) {
			cnt_min = Math.min(cnt_min, cur_cnt);
			return;
		}
		// pruning-b
		if (start > end) {
			return;
		}
		back_tracking(start*2, end, cur_cnt+1);
		back_tracking((start*10)+1, end, cur_cnt+1);
	}
	
	
	
}