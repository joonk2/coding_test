import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String[] arr = br.readLine().split(" ");
		int student = Integer.parseInt(br.readLine());
		
		int[] lst = new int[N];
		for (int i = 0; i < N; i++) {
			lst[i] = Integer.parseInt(arr[i]);
		}
		
		for (int i = 0; i < student; i++) {
			String[] s_arr = br.readLine().split(" ");
			int gender = Integer.parseInt(s_arr[0]);
			int button_idx = Integer.parseInt(s_arr[1]);
			
			int idx = button_idx-1;
			
			if (gender == 1) {
				for ( int k = idx; k < lst.length; k += (idx+1) ) {
					lst[k] = 1-lst[k];
				}
			}
			else if (gender == 2) {
				// 어차피 양옆이 같으나 다르나 본인은 바꿔야한다
				lst[idx] = 1-lst[idx];
				
				int x = 1;
				while (idx-x >= 0 && idx+x < N) {
					if (lst[idx - x] == lst[idx + x]) {
						lst[idx - x] = 1- lst[idx - x];
						lst[idx + x] = 1 - lst[idx + x];
						x++;
					}
					else {
						// 대칭이 달라지자마자 while문 종료
						break;
					}
				}
				
			}
					
		}
		
		
		
		for (int k = 0; k < N; k++) {
			System.out.print(lst[k] + " ");
			if ((k+1)%20 == 0) {
				System.out.println();
				
			}
		}
		
		
		
		
		
	}
}