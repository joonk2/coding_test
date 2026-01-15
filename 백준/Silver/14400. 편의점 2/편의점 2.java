/*
x의 중앙값, y의 중앙값
들을 좌표로 만들고 반복문을 통해 구하자 
*/


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

// List;
import java.util.List;
import java.util.ArrayList;

// sort
import java.util.Collections;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		List<int[]> lst = new ArrayList<>();
		List<Integer> x_lst = new ArrayList<>();
		List<Integer> y_lst = new ArrayList<>();
		
	
		for (int i = 0; i < N; i++) {
			String[] xy = br.readLine().split(" ");
			int x = Integer.parseInt(xy[0]);
			int y = Integer.parseInt(xy[1]);
			lst.add(new int[] {x,y});
			x_lst.add(x);
			y_lst.add(y);
		}
		
		// sort
		Collections.sort(x_lst);
		Collections.sort(y_lst);
		
		// x좌표 기준 오름차순 정렬
		Collections.sort(lst, (a,b) -> a[0]-b[0] );
		
		
		// mid (x, y)
		int mid_x = x_lst.get(x_lst.size() / 2);
		int mid_y = y_lst.get(y_lst.size() / 2);
		
		
		// res
		long answer = 0;
		for (int[] i : lst) {
			answer += Math.abs(mid_x - i[0]) + Math.abs(mid_y - i[1]);
		}
		System.out.println(answer);
	}
}