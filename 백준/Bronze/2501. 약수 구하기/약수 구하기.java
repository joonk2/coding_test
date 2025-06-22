import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		List<Integer> res = my_detecter(N, K);
//		System.out.println(res);
		int answer = 0;
		if (res.size() < K) {
			answer = 0;
		}
		else {
		 answer = res.get(K-1);	
		}
		System.out.println(answer);
		
		
	}
	public static List<Integer> my_detecter(int p, int x) {
		List<Integer> lst = new ArrayList<>();
		for (int q = 1; q < p+1; q++) {
			if (p % q == 0) {
//				System.out.println(q);
				lst.add(q);
			}
		}
		return lst;
	}
	
}