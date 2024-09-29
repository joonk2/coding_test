# 2. bfs
from collections import deque

def bfs(si, sj):
    q = deque([])
    q.append((si, sj))
    v[si][sj] = 1
    cnt = 1

    while q:
        ci, cj = q.popleft()

        for di, dj in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            ni = ci+di
            nj = cj+dj

            if 0 <= ni < N and 0 <= nj < N and arr[ni][nj] == 1 and v[ni][nj] == 0:
                q.append((ni, nj))
                v[ni][nj] = 1
                cnt += 1
    return cnt




# 1. 입출력을 위한 세팅
N = int(input())

arr = [list(map(int, input())) for _ in range(N)]
v = [ [0] * N for _ in range(N)]
ans = []

for i in range(N):
    for j in range(N):
        if arr[i][j] == 1 and v[i][j] == 0:
            ans.append(bfs(i, j))

ans.sort()
print(len(ans), *ans, sep = '\n')