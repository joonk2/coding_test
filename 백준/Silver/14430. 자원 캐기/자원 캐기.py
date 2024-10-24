import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**3)



def dfs(r, c):
    cnt = 0
    # 끝 좌표면 그냥 반환
    if r == N-1 and c == M-1:
        return arr[r][c]

    # -2가 아니라면 이미 방문했다
    if v[r][c] != -2:
        return v[r][c]

    if c+1 < M: # 우측으로 이동
        cnt = max(cnt, dfs(r, c+1))
    if r+1 < N: # 아래로 이동
        cnt = max(cnt, dfs(r+1, c))

    v[r][c] = cnt + arr[r][c]
    return v[r][c]



N, M = list(map(int, input().strip().split()))
arr = [list(map(int, input().strip().split())) for _ in range(N)]
v = [[-2]*M for _ in range(N)]
print(dfs(0,0))