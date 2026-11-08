/*
내 사고의 흐름

1. 구간 람다정렬
2. pq 오름차순을 통해 각배열마다 끝나는시간 + 10 을 추가한다.
첫 값은 그냥 대입하고 idx = 1부터 pq의 첫번째 원소보다 작으면 add, 그외는 poll()
*/

import java.util.Arrays;
import java.util.PriorityQueue;


class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        int N = book_time.length;
        
        int[][] interval = new int[N][2];
        for (int i = 0; i < N; i++) {
            String[] start = book_time[i][0].split(":");
            String[] end = book_time[i][1].split(":");
            
            int start_h = Integer.parseInt(start[0]);
            int start_m = Integer.parseInt(start[1]);
            int end_h = Integer.parseInt(end[0]);
            int end_m = Integer.parseInt(end[1]);
            
            int s = (start_h * 60) + start_m;
            int e = (end_h * 60) + end_m;
            
            interval[i][0] = s;
            interval[i][1] = e;
        }
        
        // 1. 람다정렬 
        Arrays.sort(interval, (a,b) -> {
            
            // 1-1. 시작시간이 같다면, 종료시간 빠른순
            if (a[0] == b[0]) {
                return Integer.compare(a[1], b[1]);
            }
            
            // 1-2. 시작시간 빠른순 정렬
            return Integer.compare(a[0], b[0]);
        });
        
        // 2. pq (오름차순)
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        // 3. 첫값은 대입
        int first_start = interval[0][0];
        int first_end = interval[0][1];
        pq.offer(first_end + 10);
        answer++;
        
        // 4. 2번째 예약부터 검사
        for (int i = 1; i < N; i++) {
            // 4-1. pq의 첫번쨰 원소보다 다음 예약 시작시간이 짧으면 pq에 추가
            if (pq.peek() > interval[i][0]) {
                pq.add(interval[i][1] + 10);
                answer++;
                continue;
            }
            
            // 4-2. 그렇지 않으면 -> pq.poll(), 그리고 다음 예약손님 끝나는 시간 추가;
            pq.poll();
            pq.add(interval[i][1] + 10);
        }
        
        
        return answer;
    }
}