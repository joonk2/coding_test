/*
이 코드는 내림차순 pq를 통해 n만큼 반복하여 제일 큰 값을 1씩 빼는 코드이다.
최악의 경우 ( 2만 * log(2만) ) + ( 100만 * log(2만) )
*/

import java.util.PriorityQueue;
import java.util.Collections;


class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        // 0. 조기종료 (n >= 배열의 합)
        long temp_sum = 0;
        for (int w : works) {
            temp_sum += w;
        }
        if (temp_sum <= n) return 0;
        
        
        // 1. 내림차순 pq (가장큰 원소만 내림차순 정렬, 나머지는 정렬X)
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        // 2. M*log(M)
        int M = works.length;
        for (int i = 0; i < M; i++) {
            pq.add(works[i]);
        }
        
        // 3. n만큼 빼기 100만 * log(2만) -> 최악의 경우 약 1400만
        int cnt = 0;
        while (cnt < n) {
            int max_val = pq.poll();
            int new_val = max_val-1;
            pq.offer(new_val);
            cnt++;
        }
        
        // 4. 답 계산
        while (!pq.isEmpty()) {
            int val = pq.poll();
            answer += (val * val);
        }
        return answer;
    }
}