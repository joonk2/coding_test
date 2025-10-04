import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	static int[] dist, price;
	static int min_cost = Integer.MAX_VALUE;
	static int total_dist = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] dist_arr = br.readLine().split(" ");
		String[] price_arr = br.readLine().split(" ");
		dist = new int[dist_arr.length + 1];
		price = new int[N];
		for (int i = 0; i < dist.length-1; i++) {
			dist[i] = Integer.parseInt(dist_arr[i]);
			total_dist += dist[i];
		}
		for (int i = 0; i < price.length; i++) {
			price[i] = Integer.parseInt(price_arr[i]);
		}
		
		what_is_the_answer();
	}
	
	
	
	
	static void what_is_the_answer() {
		min_cost = dist[0] * price[0];
		total_dist -= dist[0];
		for (int i = 1; i < dist.length-1; i++) {
			if (price[i] <= price[i+1]) {
				if (total_dist >= 0) {
					min_cost += (price[i] * total_dist);
					total_dist = 0;
				}
			}
		}
		System.out.println(min_cost);
	}
	
	
	
}