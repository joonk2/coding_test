import java.util.Arrays;

class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int max_people = 0;
        
        // 1-1. 손님방문 시간 배열
        int start = 0;
        int N = order.length;
        int[] finished_time = new int[N];
        
        // 1-2. 첫 손님
        int first_idx = order[0];
        int first_menu = menu[first_idx];
        finished_time[0] = first_menu;
        
        // 1-3. 배열 채우기 (손님 도착시간 vs 기계 사용가능시간)
        for (int i = 1; i < N; i++) {
            int customer_waiting = i * k;
            int machine_available = finished_time[i-1];
            int cur_idx = order[i];
            int cur_menu = menu[cur_idx];
            finished_time[i] = Math.max(customer_waiting, machine_available) + cur_menu;
        }
        
        
        // 1-4. O(N^2)
        for (int i = 0; i < N; i++) {
            int waiting = 0;
            int time = i * k;
            
            // 1-5. 기계 사용가능한 시간이 손님 기다리는 시간보다 더 걸리면 -> 대기++
            for (int j = 0; j < i+1; j++) {
                if (time < finished_time[j]) {
                    waiting++;
                }
            }
            // 1-6. 갱신
            max_people = Math.max(waiting, max_people);
        }
        
        return max_people;
    }
}