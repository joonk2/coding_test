

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static boolean[][] check = new boolean[100][100]; 
	
	public static  void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = 4;
		
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			String[] x1_y1_x2_y2 = br.readLine().split(" ");
			int x1 = Integer.parseInt(x1_y1_x2_y2[0]);
			int y1 = Integer.parseInt(x1_y1_x2_y2[1]);
			int x2 = Integer.parseInt(x1_y1_x2_y2[2]);
			int y2 = Integer.parseInt(x1_y1_x2_y2[3]);
	
			
			
			for (int x = x1; x < x2; x++) {
				for (int y = y1; y < y2; y++) {
					if (check[x][y] == false) {
						check[x][y] = true;
						cnt++;
					}
					
				}
			}
			
			
		}
		
		System.out.println(cnt);
		
		
		
		
	}
	
}