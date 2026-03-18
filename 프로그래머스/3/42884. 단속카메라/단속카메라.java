import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        // 1. 진출지점 기준 정렬
        Arrays.sort(routes, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        // 2. 첫 카메라 위치
        int camera = Integer.MIN_VALUE;
        
        for (int[] rou : routes) {
            // 3. 현재 카메라로 못 찍으면 위치 갱신
            if (camera < rou[0]) {
                camera = rou[1];
                answer++;
            }
        }
        
        return answer;
    }
}