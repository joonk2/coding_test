import java.util.Queue;
import java.util.LinkedList;

import java.util.Arrays;


class Solution {
    public int solution(int[] priorities, int location) {
        int turn = 0;
        
        // priorites 복사배열을 하나 만들어 오름차순으로 정렬
        // 그리고 복사배열의 값과 q의 값이 동일하면, q를 추출하는데 이때 target_idx, target_val과 동일하면 break 
        // 그 외는 복사배열의 idx를 하나씩 줄이고, q에서 추출
        
        
        int N = priorities.length;
        int[] largest_num_arr = new int[N];
        int largest_num_idx = N-1;
        for (int i = 0; i < N; i++) {
            largest_num_arr[i] = priorities[i];
        }
        Arrays.sort(largest_num_arr);
        
        int target_idx = location;
        int target_val = priorities[target_idx];
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int idx = i;
            int val = priorities[i];
            q.add(new int[] {idx, val});
        }
        
        // q검사
        while (!q.isEmpty()) {
            int[] cur_pos = q.poll();
            int cur_idx = cur_pos[0];
            int cur_val = cur_pos[1];
            // 만약 cur_val < largest_num_arr[largest_num_idx] -> q에 다시 추가
            // 그리고 continue
            if (cur_val < largest_num_arr[largest_num_idx]) {
                q.add(new int[] {cur_idx, cur_val});
                continue;
            }
            
            // 그렇지 않고, 같다면
            largest_num_idx--;
            turn++;
            
            // 그때, target_idx, target_val과 같다면?
            if (target_idx == cur_idx && target_val == cur_val) {
                break;
            }
        }
        
        
        return turn;
    }
}