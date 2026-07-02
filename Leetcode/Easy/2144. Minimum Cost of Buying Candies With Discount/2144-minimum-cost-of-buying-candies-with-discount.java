import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        // 1. 정렬 N logN
        Arrays.sort(cost);

        // 2. 뒤에서 2개 팔리면 3번째는 free
        int N = cost.length-1;
        int sum = 0;
        for (int i = N; i >= 0; i--) {
            if ( (N-i) % 3 == 0) sum += cost[i];
            else if ( (N-i) % 3 == 1 ) sum += cost[i];
        }

        // 3. 반환
        return sum;
    }
}