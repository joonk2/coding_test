class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int cnt = 0;
        
        int N = schedules.length;
        int week_leng = timelogs[0].length;
        
        // 컴퓨터에서는 0부터 월요일
        startday--;
        
        
        // 반복문
        // 토, 일을 제외하고 temp_cnt가 5회가 되야 만근으로 간주
        for (int i = 0; i < N; i++) {
            int temp_cnt = 0;
            for (int j = 0; j < week_leng; j++) {
                int day = (j + startday) % week_leng;

                // 만약 토요일이거나 일요일이면 skip
                if (day == 5 || day == 6) continue;
                
                // 1. 제한 시간
               	int time_limit = schedules[i] + 10;
                int limit_h = time_limit / 100;
                int limit_m = time_limit % 100;
                
                // 1-1. 만약 limit_m >= 60 이라면
                if (limit_m >= 60) {
                    limit_m %= 60;
                    limit_h++;
                }
                
                // 1-2. 다시 time_limit에 더하기
                time_limit = 0;
                time_limit += (limit_h) * 100;
                time_limit += (limit_m);
                
                
                // 2. 현재 시간
                int total_time = timelogs[i][j];

                // 3. 시간 확인
                if (total_time <= time_limit) temp_cnt++; 
            }
            
            // 각 회사원마다 만근인지 확인
            if (temp_cnt == 5) cnt++;
        }
        
        
        return cnt;
    }
}