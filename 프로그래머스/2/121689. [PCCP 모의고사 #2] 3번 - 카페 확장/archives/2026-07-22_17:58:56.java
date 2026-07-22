class Solution {
    public int solution(int[] menu, int[] order, int k) {
        int max_people = 0;
        
        // 1. 첫 값 대입
        int N = order.length;
        int[] waiting_time = new int[N];
        int first_idx = order[0];
        int first_menu = menu[first_idx];
        waiting_time[0] = first_menu;
        
        // 2. 대기시간
        // (손님오는 시간 vs 이전 손님 대기시간) + 음료 만드는 시간
        for (int i = 1; i < N; i++) {
            int visit_time = i*k;
            int prev_customer_waiting = waiting_time[i-1];
            int cur_menu = menu[order[i]];
            waiting_time[i] = Math.max(visit_time, prev_customer_waiting) + cur_menu;
        }
        
        // 3. 계산
        for (int i = 0; i < N; i++) {
            int waiting = 0;
            int cur_time = i * k;
            for (int j = 0; j < i+1; j++) {
                // 3-1. 만약 현재시간보다 음료 만드는 시간이 더 길면
                if (cur_time < waiting_time[j]) {
                    waiting++;
                }
            }
            
            // 3-2. 갱신
            max_people = Math.max(waiting, max_people);
        }
        
        return max_people;
    }
}