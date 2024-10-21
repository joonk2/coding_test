# min을 사용하는 이유는 예로 v==1일때 연속된 1의 시작을 의미하는데
# 그 전에 row2가 0보다 크다면 이전에 연속된 2가 있었던 경우를 의미한다
# 즉 cnt2를 증가시키는 것은이전에 연속된 2의 구간이 있었음을 기록
# --> 2가 연속으로 있었고, 1이 등장함으로써 그 구간이 끝났음을 표시

from collections import deque
import sys
input = sys.stdin.readline

N, M = list(map(int, input().strip().split()))
paint = [list(map(int, input().strip().split())) for _ in range(N)]
# print(arr)




res = 0

for x in range(N):  
    for y in range(M):  
        if paint[x][y] != 0:
            color = paint[x][y]
            # 오른쪽으로 진행하며
            for i in range(M - y):  # 색칠할 구역 체크
                # 범위 체크를 추가
                if paint[x][y + i] != 0:
                    # 같은 색상이면 덧칠할 필요 없으므로 방문 체크
                    if paint[x][y + i] == color:
                        paint[x][y + i] = 0
                # 0을 만나면 색칠 끝
                else:
                    res += 1
                    break
            # 오른쪽 끝에 도달하면 색칠 끝
            else: 
                res += 1

print(res)