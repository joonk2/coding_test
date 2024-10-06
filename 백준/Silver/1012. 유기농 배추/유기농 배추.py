from collections import deque
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**6)
# 2. dfs 함수
def dfs(graph, x, y):
    graph[x][y] = 0  # 배추 위치 방문 처리

    # 상하좌우로 탐색
    for dx, dy in ((-1, 0), (1, 0), (0, -1), (0, 1)):
        nx = x + dx
        ny = y + dy

        # 그래프의 범위 내에서 미방문한 배추가 있는 경우
        if 0 <= nx < M and 0 <= ny < N and graph[nx][ny] == 1:
            dfs(graph, nx, ny)  # 재귀 호출

# 1. 입출력 세팅
T = int(input())

for _ in range(T):
    M, N, K = list(map(int, input().strip().split()))
    cnt_worm = 0
    graph = [[0]*N for _ in range(M)]

    for _ in range(K):
        X, Y = list(map(int, input().strip().split()))
        graph[X][Y] = 1

    for i in range(M):
        for j in range(N):
            if graph[i][j] == 1:
                dfs(graph, i, j)  # DFS 호출
                cnt_worm += 1

    print(cnt_worm)