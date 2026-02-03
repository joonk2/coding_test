class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        // 최소, 최대 구하기
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] < left) left = diffs[i];
            if (diffs[i] > right) right = diffs[i];
        }
       
        // 이진탐색
        int req_min_level = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            // 현재 레벨로 퍼즐을 풀 수 있다면
            if (can_solve_puzzle(diffs, times, limit, mid)) {
                req_min_level = mid;
                right = mid - 1;
            }
            // 현재 레벨로 퍼즐 못푼다면
            else if (!can_solve_puzzle(diffs, times, limit, mid)) {
                left = mid + 1;
            }
        }
        return req_min_level;
    }
    
    
    
    
    
    static boolean can_solve_puzzle(int[] diffs, int[] times, long limit, int mid) {
        long cur_solving_time = 0;
        for (int i = 0; i < times.length; i++) {
            int time_cur = times[i];
            int time_prev;
            // 1-1. 현재 레벨이 더 낮을 때
            if (mid < diffs[i]) {
                // 만약 첫빠따면 이전 퍼즐 0 처리
                if (i-1 < 0) time_prev = 0;
                // 아니라면 이전퍼즐 -> i-1
                else time_prev = times[i-1];
                
                int wrong_cnt = diffs[i] - mid;
                
                // 계산
                cur_solving_time += ((time_prev + time_cur) * wrong_cnt) + times[i];
            }
            // 1-2. 현재 레벨 이상이면
            else if (mid >= diffs[i]) {
                cur_solving_time += times[i];
            }
        }
        
        // 판별
        // 2-1. 제한 이내면 solve 가능
        if (cur_solving_time <= limit) {
            return true;
        }
        // 2-2. 제한 초과면 solve 불가능
        return false;
    }
    
    
    
    
}