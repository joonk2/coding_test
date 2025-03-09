import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

// import java.util.Arrays;

public class Main {
	// alpabet 26 &&  left, right  [0], [1]
	static int[][] tree = new int[26][2];
 	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
//		char[] tree = new char[N+1];
		
		for (int i = 0; i < N; i++) {
			String[] Node_arr = br.readLine().split(" ");	
//			char parent = Node_arr[0].charAt(0);
//			char lc = Node_arr[1].charAt(0);
//			char rc = Node_arr[2].charAt(0);
			
			//  'A'를 빼면 0부터 시작하는 숫자로 변환
			// ex) --> B-'A' = 66 - 65
			int parent = Node_arr[0].charAt(0) - 'A';
			int lc, rc;
			
			// lc
			if (Node_arr[1].charAt(0) == '.') {
				lc = -1;
			}
			else {
				lc = Node_arr[1].charAt(0) - 'A';
			}
			
			// rc
			if (Node_arr[2].charAt(0) == '.') {
				rc = -1;
			}
			else {
				rc = Node_arr[2].charAt(0) - 'A';
			}
			
			
			
			tree[parent][0] = lc;
			tree[parent][1] = rc;
			
		}
		
		
		pre_order(0);
		System.out.println();
		
		in_order(0);
		System.out.println();
		
		post_order(0);
		System.out.println();
		
		
		
		
//		System.out.println(Arrays.toString(tree));
		
	}
	
	
	static void pre_order(int node) {
		if (node == -1) return;
		System.out.print( (char) (node + 'A') );
		pre_order(tree[node][0]);
		pre_order(tree[node][1]);
	}
	
	
	static void in_order(int node) {
		if (node == -1) return;
		in_order(tree[node][0]);
		System.out.print( (char) (node + 'A') );
		in_order(tree[node][1]);
	}
	
	
	static void post_order(int node) {
		if (node == -1) return;
		post_order(tree[node][0]);
		post_order(tree[node][1]);
		System.out.print( (char) (node + 'A')  );
	}
	
	
	
	
	
	
	
}
