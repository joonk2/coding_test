class Solution {
    public int solution(int n, int[] stations, int w) {
        
        
        // int n1 = 29;
        // int[] stations1 = new int[] {2, 9, 23};
        // int w1 = 2;
        // res -> 4
        
        
        int res = my_inspector(n, stations, w);
        return res;
    }
    
    
    static int my_inspector(int n, int[] stations, int w) {
        int cnt = 0;
        
        // 예외처리 (stations 길이가 1일때)
        if (stations.length == 1) {
            int idx = 0;
            int start = 1;
            int end = n;
            int s = stations[idx] - w;
            int e = stations[idx] + w;
            
            // 앞구간 처리 (기지국 설치할 곳이 있다면)
            if (s - start >= 1) {
                System.out.println(s-start);
                cnt += (int) (Math.ceil( (double) (s-start) / ((2*w)+1)) );
            }
            
            // 뒷구간 처리 (기지국 설치할 곳이 있다면)
            if (end - e >= 1) {
                cnt += (int) (Math.ceil( (double) (end-e) / ((2*w)+1) ));
            }
            return cnt;
        }
        
        
        // stations.length >= 2 일때
        
        // 0. 구간을 갱신할 첫 시작점
        int start = 1;
        int N = stations.length;
        for (int i = 0; i < N; i++) {
            int s = stations[i] - w;
            int e = stations[i] + w;
            
            // 1. idx 맨처음
            if (i == 0) {
                // 1-1. 길이가 1이상일때만 계산
                if (s - start >= 1) {
                    cnt += (int) (Math.ceil( (double) (s-start) / ((2*w)+1)) );
                }
                // 1-2. 다음 시작점을 갱신
                start = e+1;
            }
            // 2. idx 맨끝
            else if (i == N-1) {
                // 2-1. 길이가 1이상일떄만 계산 (구간 다 커버 못할때)
                if (s - start >= 1) {
                    cnt += (int) (Math.ceil( (double) (s-start) / ((2*w)+1) ));
                }
                // 2-2. idx가 맨끝이니 끝도 계산 (구간을 커버하지 못할때)
                if (n-(e+1) >= 1) {
                    cnt += (int) (Math.ceil( (double) (n-e) / ((2*w)+1) ));
                }
            }
            
            // 3. idx 맨처음과 맨끝사이
            else {
                // 3-1. 길이가 1이상일떄 (구간 다 커버못할때)
                if (s - start >= 1) {
                    cnt += (int) (Math.ceil( (double) (s-start) / ((2*w)+1) ));
                }
                // 3-2. 다음 시작점 갱신
                start = e + 1;
            }
        }
        
        // 4. 횟수 반환
        return cnt;
    }
}