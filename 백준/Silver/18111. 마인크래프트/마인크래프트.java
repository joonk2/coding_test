import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int[] height_cnt = new int[257];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = br.readLine().split(" ");
        int N = Integer.parseInt(arr[0]);
        int M = Integer.parseInt(arr[1]);
        int B = Integer.parseInt(arr[2]);
        
        int max_height = -99;
        int min_height = 99;
        
        int[][] matrix = new int[N][M];
        for (int y = 0; y < N; y++) {
            String[] col = br.readLine().split(" ");
            for (int x = 0; x < M; x++) {
                matrix[y][x] = Integer.parseInt(col[x]);
                int temp = matrix[y][x];
                height_cnt[temp]++;
                
                min_height = Math.min(min_height, temp);
                max_height = Math.max(max_height, temp);
            }
        }
        
        int min_time = Integer.MAX_VALUE;
        int best_height = -1;
        
        for (int h = min_height; h < max_height + 1; h++) {
            int remove = 0;
            int add = 0;
            
            for (int i = min_height; i < max_height + 1; i++) {
                if (i > h) {
                    remove += (i - h) * height_cnt[i];  
                } else if (i < h) {
                    add += (h - i) * height_cnt[i];    
                }
            }

            // in case, insufficient of B;
            if (remove + B < add) {
                continue;
            }

            int time = (remove * 2) + add;
            
            // res
            if (time < min_time || (time == min_time && h > best_height)) {
                min_time = time;
                best_height = h;
            }
        }
        
        System.out.println(min_time + " " + best_height);
    }
}


/* 

tc-1
3 4 99
0 0 0 0
0 0 0 0
0 0 0 1
#1 -> 2 0


tc-2
3 4 50
4 1 1 1
2 1 1 1
1 1 1 2



tc-3
3 4 1
64 64 64 64
64 64 64 64
64 64 64 63
#3 -> 1 64


tc-4
3 4 0
64 64 64 64
64 64 64 64
64 64 64 63
#4 -> 22 63

*/