import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// sort
import java.util.Arrays;
import java.util.Collections;

// lst
import java.util.List;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		// 조기종료
		if (N == 1) {
			int nums = Integer.parseInt(br.readLine());
			System.out.println(nums);
			return;
		}
		
		
		// N >= 2
		String[] nums = br.readLine().split(" ");
		int[] arr = new int[N];

		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(nums[i]);
		}		
		Arrays.sort(arr);
		
		
		
		int median1 = arr[N/2 - 1];
		int median2 = arr[N/2];
		
		int min_sum_1 = 0;
		int min_sum_2 = 0;
		
		List<int[]> lst = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			min_sum_1 += Math.abs(median1 - arr[i]);
			min_sum_2 += Math.abs(median2 - arr[i]);
		}
		
		lst.add(new int[] {median1, min_sum_1});
		lst.add(new int[] {median2, min_sum_2});
		
		// 정렬
		Collections.sort(lst, (a,b) -> a[1]-b[1]);
		

		// 결과
		// 둘다 같을때는 왼쪽 출력
		if (lst.get(0)[1] == lst.get(0)[1]) {
			System.out.println(lst.get(0)[0]);
		}
		// 둘다 다를때 왼쪽 출력
		else if (lst.get(0)[1] != lst.get(0)[1]) {
			System.out.println(lst.get(0)[0]);
		}
		
		
		
	}	
}