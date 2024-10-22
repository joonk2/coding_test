# 아래 2가지 경우인 3D arr로 생각해야한다
# 벽을 부수는 것, 부수지 않는 경우


import sys
from collections import deque 

input = sys.stdin.readline

def bfs(x, y):
    q = deque([])
    q.append((x, y, 0)) 
    graph[x][y][0] = 1  # 시작점 방문 처리

    while q:
        x, y, wall = q.popleft()

        # 목표에 도달했을 때
        if x == N - 1 and y == M - 1:
            return graph[x][y][wall]

        for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
            nx = x + dx
            ny = y + dy

            if 0 <= nx < N and 0 <= ny < M:
                # 벽이 없을 때
                if arr[nx][ny] == 0 and graph[nx][ny][wall] == 0:
                    graph[nx][ny][wall] = graph[x][y][wall] + 1
                    q.append((nx, ny, wall))

                # 벽이 있는 경우 (아직 벽을 부수지 않은 상태에서 부수기)
                elif arr[nx][ny] == 1 and wall == 0 and graph[nx][ny][1] == 0:
                    graph[nx][ny][1] = graph[x][y][0] + 1
                    q.append((nx, ny, 1))

    # 도달 못하는 경우
    return -1


N, M = list(map(int, input().strip().split()))
arr = [list(map(int, input().strip())) for _ in range(N)]  # 0 또는 1로 이루어진 2D 리스트
graph = [[[0] * 2 for _ in range(M)] for _ in range(N)]  

# BFS 시작
print(bfs(0, 0))