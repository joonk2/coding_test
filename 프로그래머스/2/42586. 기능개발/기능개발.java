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
        // 우선 첫 값만 삽입
        int size_idx = 0;
        answer[size_idx]++;
        int max_num = end_time[size_idx];
        for (int i = 1; i < N; i++) {
            // 3. 이전값보다 작거나 같으면 삽입
            if (end_time[i] <= max_num) {
                answer[size_idx]++;
            }
            // 4. 크다면 가장 큰 수 갱신
            else if (end_time[i] > max_num) {
                max_num = end_time[i];
                size_idx++;
                answer[size_idx]++;
            }
        }
        
        // 5. 정답 배열
        int[] res = new int[size_idx+1];
        for (int i = 0; i < size_idx+1; i++) {
            res[i] = answer[i];
        }
        
        System.out.println(size_idx);
        
        return res;
    }
}