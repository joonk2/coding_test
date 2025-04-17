import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// import java.util.Arrays;
import java.util.ArrayList;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] card_num_arr = br.readLine().split(" ");
		
		
		ArrayList<Integer> student_lst = new ArrayList<>();
		int[] card_num = new int[N];
		for (int i = 0; i < N; i++) {
			card_num[i] = Integer.parseInt(card_num_arr[i]);
			student_lst.add(i-card_num[i], i+1);
		}
		
		for (int i : student_lst) {
			System.out.print(i + " ");
		}

				
	}
}