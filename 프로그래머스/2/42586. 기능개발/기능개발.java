class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        // 1. 각 작업의 종료시간을 만들자
        int N = speeds.length;
        int[] answer = new int[N];
        int[] end_time = new int[N];
        for (int i = 0; i < N; i++) {
            int cur_end_time = (int) Math.ceil( (100 - progresses[i]) / (double) speeds[i] );
            end_time[i] = cur_end_time;
        }
        
        // 2. 종료시간 배열 값 추가
        int size_idx = 0;
        int start_idx = 0;
        while (start_idx < N) {
            int temp_cnt = 1;
            for (int next_idx = start_idx + 1; next_idx < N; next_idx++) {
                // 2-1. 만약 현재 숫자보다 다음 숫자가 작거나 같다면
                if (end_time[start_idx] >= end_time[next_idx]) {
                    temp_cnt++;
                }
                // 2-2. 더 크면 break
                else if (end_time[start_idx] < end_time[next_idx]) break;
            }
            
            // 2-3. 배열에 추가
            answer[size_idx] += temp_cnt;
            size_idx++;
            
            // 2-4. 다음 시작 idx 갱신
            start_idx += temp_cnt;
        }
        
        // 3. 결과 배열 반환
        int[] res = new int[size_idx];
        for (int i = 0; i < size_idx; i++) {
            res[i] = answer[i];
        }
        
        return res;
    }
}