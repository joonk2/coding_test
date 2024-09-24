# https://www.youtube.com/watch?v=ATs2_KiBV2E

# import sys
# sys.stdin = open("input.txt", "r")

def bfs(si, sj, ei, ej):
    q = []
    v = [[0] * M for _ in range(N)]

    q.append((si, sj))
    v[si][sj] = 1 # 방문 표시

    while q:
        ci, cj = queue.pop(0)
        if (ci, cj) == (ei, ej): # 현재가 목적지 좌표라면
            return v[ei][ej]

        # 4방향 범위내, 조건에 맞으면 queue에 삽입
        for di, dj in ((-1,0), (1,0), (0,-1), (0,1)): #상하좌우
            ni, nj = ci + di, cj + dj
            if 0 <= ni < N and  0 <= nj < M and arr[ni][nj] == 1 and v[ni][nj] == 0:
                # 만약 다음 좌표의 행과 열이 입력한 범위 내에 있고, 길이 있으며(=1), 방문하지 않았는 곳이라면(=0)
                q.append((ni, nj))
                v[ni][nj] = v[ci][cj]+1

N,M = map(int, input().split())
arr = [list(map(int, input())) for _ in range(N)]

ans = bfs(0, 0, N-1, M-1)
print(ans)
