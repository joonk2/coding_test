import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pq.add( (long) scoville[i] );
        }
        
        while (true) {
            if (pq.peek() >= K) break; 
            if (pq.size() < 2) return -1;
            
            long first = pq.poll();
            long second = pq.poll();
            
            
            long temp = first + (2 * second);
            pq.add(temp);
            answer++;
        }
        return answer;
    }
}