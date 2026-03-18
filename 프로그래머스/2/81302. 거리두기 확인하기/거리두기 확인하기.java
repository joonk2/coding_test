import java.util.Arrays;

class Solution {
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,-1,1};
    
    static int[] dr_diag = {-1, -1, 1, 1};
    static int[] dc_diag = {-1, 1, -1, 1};
    
    static int row, col;
    
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int t = 0; t < places.length; t++) {
            row = places[0].length;
            col = places[0][0].length();
            char[][] arr = new char[row][col];
            
            // 1. 배열 생성
            for (int r = 0; r < row; r++) {
                arr[r] = places[t][r].toCharArray();
            }
            
            // 2. 탐색
            boolean flag = false;
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (arr[r][c] == 'P') {
                        boolean is_detected = detector(r, c, arr);
                        if (is_detected) {
                            flag = true;
                            break;
                        }
                    }
                    // 2-1. 방역수칙 어긴놈 적발시 -> 탐색종료
                    if (flag) break;
                }
                // 2-2. 방역수칙 어긴놈 적발시 -> 탐색 종료
                if (flag) break;
            }
            // 결과
            if (flag) answer[t] = 0;
            else if (!flag) answer[t] = 1;
        }
        return answer;
    }
    
    
    
    // 3. 함수 (탐색)
    static boolean detector(int or, int oc, char[][] arr) {
        // 3-1. 동서남북
        boolean is_partition;
        for (int d = 0; d < 4; d++) {
            is_partition = false;
            int cr = or;
            int cc = oc;
            for (int x = 0; x < 2; x++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                
                // 범위 밖 -> 볼 필요없으니 break
                if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
                
                // 범위 내
                // 파티션이 있다면?
                if (arr[nr][nc] == 'X') {
                    is_partition = true;
                }
                // 사람이라면?
                else if (arr[nr][nc] == 'P') {
                    // 파티션 없다면 
                    // 방역수칙 어긴놈 검거
                    if (!is_partition) {
                        return true;
                    }
                }
                // 좌표 갱신
                cr = nr;
                cc = nc;
            }
        }
        
        
        // 3-2. 대각선
        for (int d = 0; d < dr_diag.length; d++) {
            int nr = or + dr_diag[d];
            int nc = oc + dc_diag[d];
            
            // 범위 밖 -> skip
            if (nr < 0 || nr >= row || nc < 0 || nc >= col) continue;
            
            // 만약 다음 좌표가 사람이면
            if (arr[nr][nc] == 'P') {
                // 양쪽이 파티션이 아닐때 -> 거리두기수칙 위반
                if (arr[nr][oc] != 'X' || arr[or][nc] != 'X') return true;    
            }            
        }
        return false;
    }
            

    
    
}